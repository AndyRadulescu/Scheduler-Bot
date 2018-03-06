import { computed } from 'ember/object'
import AjaxService from 'ember-ajax/services/ajax';


export default AjaxService.extend({
    headers: computed('', {
        get() {
            let headers = {};
            const authToken = window.localStorage.token;
            if (authToken) {
                headers['authorization'] = `Barrer ${authToken}`;
            }
            return headers;
        }
    })
});