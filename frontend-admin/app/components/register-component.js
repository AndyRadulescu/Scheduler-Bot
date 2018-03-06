import Component from '@ember/component';
import { inject } from '@ember/service';

export default Component.extend({
    regex: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
    url: "http://localhost:8000/api/user",
    ajax: inject(),

    actions: {
        submitForm() {
            let user = {
                name: this.$('#fullName').val(),
                email: this.$('#email').val(),
                password: this.$('#psd').val(),
            };
            let confirmPassword = this.$('#confPsd').val();

            if (user.name === "" || user.email === "" || user.password === "" || confirmPassword === "") {
                alert("Make sure to configure every field before submitting!")
            } else if (!this.isEmail(user.email)) {
                alert('Email fornat not correct  ' + user.email);
            } else if (user.password !== confirmPassword) {
                alert("Passwords do not match!");
            } else if (user.password.length < 8) {
                alert('Password to short, minimum number of characters is 8.')
            } else {
                // let aux = JSON.stringify(user);
                console.log(user);
                this.get('ajax').request(this.url, {
                    method: 'POST',
                    data: user
                });
                this.get('router').transitionTo('login');
            }
        }
    },

    isEmail(email) {
        return this.regex.test(email.toLowerCase());
    }
});