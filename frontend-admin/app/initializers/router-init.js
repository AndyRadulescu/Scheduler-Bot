export function initialize(application) {
    application.inject('component', 'router', 'router:main');
    application.inject('route', 'fb', 'service:fb');
}

export default {
    name: 'component-router-injector',
    initialize: initialize
};