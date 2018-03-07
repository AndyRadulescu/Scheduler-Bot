import AjaxService from 'ember-ajax/services/ajax';
import { computed } from '@ember/object';

export default AjaxService.extend({
    headers: computed('', {
        get() {
            let headers = {};
            const authToken = window.localStorage.token;
            console.log('token');
            if (authToken) {
                headers['Authorization'] = `Bearer ${authToken}`;
            }
            return headers;
        }
    })
});