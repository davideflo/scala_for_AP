/* XML extractor */

import scala.xml.XML
import java.io.File
import scala.collection.mutable.ListBuffer

/***************************************************************************************/
def getListOfFiles(dir: String):List[File] = {
  	val d = new File(dir)
  	if (d.exists && d.isDirectory) {
    	d.listFiles.filter(_.isFile).toList
  	} else {
    	List[File]()
  	}
}
/***************************************************************************************/
def xmlAppender(): List[List[Any]] = {
	val L = scala.collection.mutable.ListBuffer[List[Any]]()
	val files = getListOfFiles("C:Users/utente/XML_PDO")
	for (f <- files){
		var x = XML.loadFile("C:Users/utente/XML_PDO".concat("/".concat(f)) )
		var dp = x \\ "DatiPod"
		for( i <- 0 to dp.length ){
			var pod = dp(i) \\ "Pod"
			var MA = dp(i) \\ "MeseAnno"
			var Er = dp(i) \\ "Er"
			for( e <- 0 to Er.length){
				var day = e + 1
				var ea = Er(e) \\ "Er"
				val NL = List(pod, MA, day, ea)
				L += NL
			}
		}
	}
	L 
}
