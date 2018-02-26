import Route from '@ember/routing/route';
import Ember from 'ember';

export default Route.extend({
    fb: Ember.inject.service(),

    model() {
        return this.get('fb').getLoginStatus();
    }
});
