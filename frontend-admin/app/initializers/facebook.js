export function initialize(application) {
    application.inject('component', 'fb', 'service:fb');
    application.inject('route', 'fb', 'service:fb');
}

export default {
    name: 'fb',
    initialize
};
