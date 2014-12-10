@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7')

import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.*


def client = new RESTClient( 'http://www.vogella.com/' )
def resp = client.get( path : 'index.html' ) 
		https://api.bintray.com/content/vogellacompany/junit-4-tools/updatesite/0.1/features/de.simonscholz.codemodify.feature_0.1.0.201411221540.jar;publish=1
client.put(null);

assert resp.status == 200  // HTTP response code; 404 means not found, etc.
println resp.getData()


