/**
 * Created by Hiro on 28/07/2016.
 */
class WriteGpsData {
    def static void main (String[] args) {
        def file = new File('data/fells_loop.gpx')
        def slurper = new XmlSlurper()
        def gpx = slurper.parse(file)

        def markupBuilder = new groovy.xml.StreamingMarkupBuilder()

        def xml = markupBuilder.bind{
            route{
                mkp.comment(gpx.name)
                gpx.rte.rtept.each { pointer ->
                    routepoint(timestamp:pointer.time.toString()) {
                        latitude(pointer.@lat)
                        longitude(pointer.@lon)
                    }
                }
            }
        }

        def outfile = new File('data/arquivo.xml')
        outfile.write(xml.toString())
    }
}
