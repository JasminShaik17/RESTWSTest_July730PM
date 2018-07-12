package cubex.mahesh.restwstest.beans

import com.google.gson.annotations.SerializedName

data class PNRStatusBean(@SerializedName("response_code")
                         val responseCode: Int = 0,
                         @SerializedName("passengers")
                         val passengers: List<PassengersItem>?,
                         @SerializedName("reservation_upto")
                         val reservationUpto: ReservationUpto,
                         @SerializedName("from_station")
                         val fromStation: FromStation,
                         @SerializedName("journey_class")
                         val journeyClass: JourneyClass,
                         @SerializedName("boarding_point")
                         val boardingPoint: BoardingPoint,
                         @SerializedName("chart_prepared")
                         val chartPrepared: Boolean = false,
                         @SerializedName("pnr")
                         val pnr: String = "",
                         @SerializedName("debit")
                         val debit: Int = 0,
                         @SerializedName("doj")
                         val doj: String = "",
                         @SerializedName("total_passengers")
                         val totalPassengers: Int = 0,
                         @SerializedName("to_station")
                         val toStation: ToStation,
                         @SerializedName("train")
                         val train: Train)