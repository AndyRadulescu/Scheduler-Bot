import Component from '@ember/component';

export default Component.extend({
    actions: {
        login() {
            let userName = this.$('#usr').val();
            let password = this.$('#pwd').val();

            if (userName !== "" && password !== "") {
                console.log(userName + "   " + password);
                this.get('router').transitionTo('main');
            }
            else {
                alert('Login or password incorrcet!');
            }
        }
    }
});
