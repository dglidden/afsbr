package com.illusionary

import groovy.json.JsonSlurper
import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method


/**
 * User: dglidden
 * Date: 12/12/16
 *
 * Perhaps a bit silly to have this in its own class, but there you have it...
 */
class RedditClient {

    def retrieveJson(def fullname) {
        retrieveLiveJson(fullname)
        // retrieveSampleJson(name)
    }

    def retrieveLiveJson(def fullname) {
        def http = new HTTPBuilder('https://www.reddit.com/')
        // TODO set user-agent to something or other
        // http.get(path: '/r/AnimeFigures/new/.json', query: [limit: 20, before: fullname])
        http.request(Method.GET, ContentType.JSON) { req ->
            uri.path = '/r/AnimeFigures/new/.json'
            uri.query = [before: fullname]
            headers.'User-Agent' = '/r/AnimeFigures SaleScanner (by /u/ledgekindred) https://github.com/dglidden/afsbr'
        }
    }

    def retrieveSampleJson(def fullname) {
        def json = new File('/home/dglidden/Source/afsbr/src/test/main/resources/sample.json').getText('UTF-8')

        // Parse JSON
        def js = new JsonSlurper()
        js.parseText(json)
    }
}
