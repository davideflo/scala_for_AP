package scala.math
import framian._

object PUNPREDICTION {

	def which(l: List[Any], p: Int): Int = 
	{
		l.zipWithIndex.filter(_._1 == p)(0)._2
	}
/*********************************************************/
	def ConvertDay(day: String): String = {
		val converter = Map("Sun" -> "dom",
			"Mon" -> "lun",
			"Tues" -> "mar",
			"Wed" -> "mer",
			"Thurs" -> "gio",
			"Fri" -> "ven",
			"Sat" -> "sab")

		converter(day)
	}
/*********************************************************/
	def convert_day_to_angle(day: String): Double = {
		val converter = Map("dom" -> 1,
			"lun" -> 2,
			"mar" -> 3,
			"mer" -> 4,
			"gio" -> 5,
			"ven" -> 6,
			"sab" -> 7)
		scala.math.cos(converter(day) * scala.math.Pi * (1/7))
	}
/*********************************************************/
	def convert_hour_to_angle(ora: Array[Int]): Array[Double] = {
		ora.map(x => scala.math.sin((x - 12) * scala.math.Pi * (1/24)))
	}
/*********************************************************/
	def subsequent_day(day: String) : String = {
		val converter = Map("dom" -> "lun",
			"lun" -> "mar",
			"mar" -> "mer",
			"mer" -> "gio",
			"gio" -> "ven",
			"ven" -> "sab",
			"sab" -> "dom")
		converter(day)
	}
/**********************************************************/
	def dates(vec: Array[String]): Array[String] = {
		vec.map(x => x.slice(6,7) + "/" + x.slice(4,5) + "/" + x.slice(0,3))
	}
/**********************************************************/
	def add_holidays(vd: Array[String]): Array[Int] = {
		val pasqua = List("04/04/2010", "24/04/2011", "08/04/2012", "31/03/2013",
			"20/04/2014", "05/04/2015", "27/03/2016")
		val pasquetta = List("05/04/2010", "25/04/2011", "09/04/2012", "01/04/2013",
			"21/04/2014", "06/04/2015", "28/03/2016")
		val hol = scala.collection.mutable.ArrayBuffer.empty[Int]
		for(i <- 0 until vd.length){
			val x = vd(i)
			if(x.slice(0,4) == "01/01") {hol += 1}
			else if (x.slice(0,4) == "06/01") {hol += 2}
			else if (x.slice(0,4) == "25/04") {hol += 5}
			else if (x.slice(0,4) == "01/05") {hol += 6}
			else if (x.slice(0,4) == "02/06") {hol += 7}
			else if (x.slice(0,4) == "15/08") {hol += 8}
			else if (x.slice(0,4) == "01/11") {hol += 9}
			else if (x.slice(0,4) == "08/12") {hol += 10}
			else if (x.slice(0,4) == "25/12") {hol += 11}
			else if (x.slice(0,4) == "26/12") {hol += 12}
			else if (x.slice(0,4) == "31/12") {hol += 13}
			else if (pasqua.contains(x)) {hol += 3}
			else if (pasquetta.contains(x)) {hol += 4}
			else {hol += 0}
		}
		hol.toArray
	}
/*******************************************************/
	def associate_meteo_ora(data: Array[String], meteo: Frame, meteovar: String): Array[Double] = {
		val vm = scala.collection.mutable.ArrayBuffer.empty[Double]
		
	}

}


