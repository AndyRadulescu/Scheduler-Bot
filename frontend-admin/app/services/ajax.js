import AjaxService from 'ember-ajax/services/ajax';
import { inject } from '@ember/service'

export default AjaxService.extend({
    utils: inject('utils'),

    /**
     * Custom request to automatically set the authorization header.
     * @param {} url 
     * @param {*} params 
     */
    myRequest(url, params) {
        params['headers'] = { 'Authorization': this.get('utils').get('token') };
        return this.request(url, params);
    }
});