'use strict';

module.exports = function (environment) {
    let ENV = {
        modulePrefix: 'frontend-admin',
        environment,
        rootURL: '/',
        locationType: 'auto',
        EmberENV: {
            FEATURES: {
                // Here you can enable experimental features on an ember canary build
                // e.g. 'with-controller': true
            },
            EXTEND_PROTOTYPES: {
                // Prevent Ember Data from overriding Date.parse.
                Date: false
            }
        },

        APP: {
            // Here you can pass flags/options to your application instance
            // when it is created
        }
    };

    if (environment === 'development') {
        // ENV.APP.LOG_RESOLVER = true;
        // ENV.APP.LOG_ACTIVE_GENERATION = true;
        // ENV.APP.LOG_TRANSITIONS = true;
        // ENV.APP.LOG_TRANSITIONS_INTERNAL = true;
        // ENV.APP.LOG_VIEW_LOOKUPS = true;
    }

    if (environment === 'test') {
        // Testem prefers this...
        ENV.locationType = 'none';

        // keep test console output quieter
        ENV.APP.LOG_ACTIVE_GENERATION = false;
        ENV.APP.LOG_VIEW_LOOKUPS = false;

        ENV.APP.rootElement = '#ember-testing';
        ENV.APP.autoboot = false;
    }

    if (environment === 'production') {
        // here you can enable a production-specific feature
    }

    ENV.FB = {
        appId: 433030660488215,
        version: 'v2.7',
        xfbml: true
    }

    ENV.contentSecurityPolicy = {
        'default-src': "'none'",
        'script-src': "'self' 'unsafe-eval' http://example.com:35729 https://connect.facebook.net http://connect.facebook.net https://graph.facebook.com",
        'font-src': "'self'",
        'connect-src': "'self' ws://example.com:35729",
        'img-src': "'self' https://www.facebook.com",
        'style-src': "'self' 'unsafe-inline'",
        'media-src': "'self'",
        'frame-src': "http://static.ak.facebook.com http://staticxx.facebook.com https://s-static.ak.facebook.com https://www.facebook.com http://www.facebook.com"
    }

    return ENV;
};