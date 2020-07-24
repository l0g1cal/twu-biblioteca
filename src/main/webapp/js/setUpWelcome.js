export default function setUpWelcome(dom, api) {
  async function getWelcome() {
    const request = new api.Request(api.requestType.POST, "welcome", null);

    const success = (response) => {
      console.log(response);
      window.alert(response.message);
    };

    const failure = (error) => {
      window.alert(error);
    };
    await api.call(request).then(success).catch(failure);
  }

  dom.onLoad(getWelcome);
}
