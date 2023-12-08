// 최종 수정 : 23.12.08
// 수정 버전 : 23.12.05

data class ReservationPerson(
    val name: String,       // 이름
    var roomNum: Int,       // 방 번호
    var checkIn: String,    // 체크인
    var checkOut: String,   // 체크아웃
    val money: Int,         // 소지금
    val reservationFee: Int // 지불한 예약금
)
