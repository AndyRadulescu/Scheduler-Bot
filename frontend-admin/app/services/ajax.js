import AjaxService from 'ember-ajax/services/ajax';
import { inject } from '@ember/service'

export default AjaxService.extend({
    utils: inject('utils'),

    myRequest(url, params) {
        params['headers'] = { 'Authorization': this.get('utils').get('token') };
        return this.request(url, params);
    }
});