package com.illusionary

import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder


/**
 * User: dglidden
 * Date: 12/12/16
 *
 * Perhaps a bit silly to have this in its own class, but there you have it...
 */
class RedditClient {

    def retrieveJson(def id) {
        retrieveLiveJson(id)
        // retrieveSampleJson(name)
    }

    def retrieveLiveJson(def id) {
        def http = new HTTPBuilder('https://www.reddit.com/')
        http.get(path: '/r/AnimeFigures/new/.json', query: [limit: 10, after: id])
    }

    def retrieveSampleJson(def id) {
        def json = new File('/home/dglidden/Source/afsbr/src/test/main/resources/sample.json').getText('UTF-8')

        // Parse JSON
        def js = new JsonSlurper()
        js.parseText(json)
    }
}
