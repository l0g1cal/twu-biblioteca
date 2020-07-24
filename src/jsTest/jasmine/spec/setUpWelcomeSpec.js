import setUpWelcome from "../../../main/webapp/js/setUpWelcome.js";
import * as mockDOM from "./mocks/mockDOM.js";
import * as mockAPI from "./mocks/mockCallServer.js";

describe("welcome message", function () {
  beforeEach(function () {
    spyOn(window, "alert");

    mockDOM.reset();
    mockAPI.reset();
  });

  it("should display alert on loading home page", function (done) {
    setUpWelcome(mockDOM, mockAPI);

    mockAPI.setRequestSuccessful(true);
    mockAPI.setResponse({
      message:
        "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
    });

    mockDOM.load().then(() => {
      expect(alert).toHaveBeenCalledWith(
        "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"
      );

      const request = new mockAPI.Request("POST", "welcome", null);
      expect(mockAPI.request).toEqual(request);
      done();
    });
  });
});
