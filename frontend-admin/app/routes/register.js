import Route from '@ember/routing/route';

export default Route.extend({
    model() {
        return {
            fullName: 'Andy Radulescu',
            email: 'andy@gmail.com',
            password: '1111111111'
        }
    }
});
