import Component from '@ember/component';

export default Component.extend({

    actions: {
        submitForm() {
            let fullName = this.$('#fullName').val();
            let email = this.$('#email').val();
            let password = this.$('#psd').val();
            let confirmPassword = this.$('#confPsd').val();
            if (fullName === "" || email === "" || password === "" || confirmPassword === "") {
                alert("Make sure to configure every field before submitting!")
            } else if (password !== confirmPassword) {
                alert("Passwords do not match!");
            } else {
                console.log(`${fullName}  ${email}  ${password}  ${confirmPassword}`)
            }
        }
    }
});
