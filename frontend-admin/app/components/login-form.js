import Component from '@ember/component';
import { inject } from '@ember/service';

export default Component.extend({
    ajax: inject(),

    url: "http://localhost:8000/api/user",
    init() {
        this._super(...arguments);
    },

    actions: {
        regularLogin() {
            let email = this.$('#email').val();
            let password = this.$('#psd').val();

            if (email !== "" && password !== "") {
                // console.log(email + "   " + password);
                this.get('ajax').request(this.url + `/${email}/${password}`, {
                    method: 'GET',
                }).then((res) => {
                    if (!res) {
                        alert('This user is not registerd yet! Register first!');
                        return;
                    }
                    // console.log(res);
                    window.localStorage.token = res.token;
                    this.get('router').transitionTo('main');
                }).catch(error => console.log(error));
            }
            else {
                alert('Login or password incorrcet!');
            }
        }
    }
});
