package com.illusionary

import groovy.json.JsonSlurper
import groovyx.net.http.HTTPBuilder


/**
 * User: dglidden
 * Date: 12/12/16
 */
class RedditClient {

    def retrieveJson(def name) {
        retrieveLiveJson(name)
        // retrieveSampleJson(name)
    }

    def retrieveLiveJson(def name) {
        def http = new HTTPBuilder('https://www.reddit.com/')
        http.get(path: '/r/AnimeFigures/new/.json', query: [limit: 10, since: name])
    }

    def retrieveSampleJson(def name) {
        def json = new File('/home/dglidden/Source/afsbr/src/test/main/resources/sample.json').getText('UTF-8')

        // Parse JSON
        def js = new JsonSlurper()
        js.parseText(json)
    }
}
