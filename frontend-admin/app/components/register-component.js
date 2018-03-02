import Component from '@ember/component';

export default Component.extend({
    regex: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,

    actions: {
        submitForm() {
            let user = {
                fullName: this.$('#fullName').val(),
                email: this.$('#email').val(),
                password: this.$('#psd').val(),
                confirmPassword: this.$('#confPsd').val(),
            }

            if (user.fullName === "" || user.email === "" || user.password === "" || user.confirmPassword === "") {
                alert("Make sure to configure every field before submitting!")
            } else if (!this.isEmail(user.email)) {
                alert('Email fornat not correct  ' + user.email);
            } else if (user.password !== user.confirmPassword) {
                alert("Passwords do not match!");
            } else if (user.password.length < 8) {
                alert('Password to short, minimum number of characters is 8.')
            } else {
                console.log(user);
                console.log(this.get('user').findAll());
                this.get('router').transitionTo('login');
            }
        }
    },

    isEmail(email) {
        return this.regex.test(email.toLowerCase());
    }
});