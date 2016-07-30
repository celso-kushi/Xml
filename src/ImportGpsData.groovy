//@Grab(group='joda-time', module='joda-time', version='2.9.4')
//import org.joda.time.DateTime
//import org.joda.time.format.DateTimeFormat


/**
 * Created by Hiro on 28/07/2016.
 */
class ImportGpsData {

    def static void main(String[] args){

        String currentDir = new File(".").getAbsolutePath()
        println(currentDir)  //D:\Grails\Groovy\.
        //Obtendo o arquivo
        def file = new File('data/fells_loop.gpx')
        //Verificando se o arquivo está acessível
        println file.exists()

        //Usando a classe XmlSlurper
        def slurper = new XmlSlurper()
        //Convertendo o arquivo obtido anteriormente
        def gpx = slurper.parse(file)
        //Acessando os dados
        println gpx
        println ''
        println gpx.time
        println gpx.@creator
        println gpx.@version

        //Para quando existir um pai com vários filhos
        // e acessando os dados dos filhos,
        // neste caso, o pai será a tag rte e os filhos a tag rtept
        gpx.rte.rtept.each {
            println it.@lon
            println it.@lag
            println it.time

            //Formatando TimeStamp usando import via Grape
            //def printableTime = new DateTime(it.time)
            //def format = DateTimeFormat.forParttner('dd/MM/yyyy - hh:mm aa')
            //println printableTime.toString(format)
        }

        //Acessando dos os arquivos da pasta
        /*
        Path dir = Paths.get('PluralSight/data')
        BasicFileAttributes attrs = Files.readAttributes(dir, BasicFileAttributes)

        //Imprimindo o que foi obtido
        println """
        Directory name: ${dir.fileName}
        Absolute path: ${dir.toAbsolutePath()}

        The file exists: ${Files.exists(dir)}
        The file is readable: ${Files.isReadable(dir)}
        The file is writable: ${Files.isWritable(dir)}
        The file is executable: ${Files.isExecutable(dir)}
        The file is a directory: ${Files.isDirectory(dir)}

        Created: ${attrs.creationTime()}
        Last modified: ${attrs.lastModifiedTime()}
        Last accessed: ${attrs.lastAccessTime()}

        Children:"""
        */
    }
}
