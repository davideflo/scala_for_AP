import scala.math

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
def convert_hour_to_angle(ora: Array[Int]): Double = {
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
	
}