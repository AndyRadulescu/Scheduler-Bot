import Component from '@ember/component';
import { inject } from '@ember/service';
import $ from 'jquery';

export default Component.extend({
    ajax: inject(),
    utils: inject('utils'),

    url: "http://localhost:8000/api/user",
    init() {
        this._super(...arguments);
    },

    actions: {
        regularLogin() {
            let email = this.$('#email').val();
            let password = this.$('#psd').val();
            this.login(email, password);
        }
    },

    login(email, password) {
        if (email !== "" && password !== "") {
            // console.log(email + "   " + password);
            this.get('ajax').request(this.url + '/login', {
                method: 'POST',
                data: {
                    email: email,
                    password: password
                }
            }).then((res) => {
                if (!res) {
                    alert('This user is not registerd yet! Register first!');
                    return;
                } else if (res.token) {
                    this.get('utils').setToken(res.token);
                    // console.log(`window token  ${window.localStorage.token}`);
                    this.get('router').transitionTo('main');
                }
            }).catch(error => console.log(error));
        }
        else {
            alert('Login or password incorrcet!');
        }
    },

    keyPress(event) {

        if (event.keyCode === 13) {
            let email = $('#email').val();
            let password = $('#psd').val();
            this.login(email, password);
        }
    }
});
