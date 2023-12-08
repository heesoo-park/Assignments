// 최종 수정 : 23.12.08

// 들어온 문자열이 숫자로만 이루어져 있는지 판별하는 함수
fun isInteger(s: String): Boolean {
    return try {
        s.toInt()
        true
    } catch (e: Exception) {
        false
    }
}

fun main() {
    // 호텔 예약 클래스 객체 생성
    val hotelReservation = HotelReservation()
    // 메뉴 선택을 저장하는 변수
    var selectedMenu: String

    while(true) {
        // 초기 메세지
        hotelReservation.initialMessage()
        // 메뉴 선택
        selectedMenu = readln()

        // 변수값이 숫자인지 확인
        // 아니라면 처음으로 이동
        if (!isInteger(selectedMenu)) {
            System.err.println("메뉴 입력은 숫자만 가능합니다.")
            continue
        }

        // 선택된 메뉴에 따라서 함수 호출
        when (selectedMenu.toInt()) {
            1 -> hotelReservation.reservation()
            2 -> hotelReservation.reservationList()
            3 -> hotelReservation.reservationSortedList()
            4 -> break
            5 -> hotelReservation.feeList()
            6 -> hotelReservation.changeReservation()
            7 -> hotelReservation.makeReceipt()
            8 -> hotelReservation.checkReceipt()
        }
    }
}





// // 수정 버전 : 23.12.05

// // 들어온 문자열이 숫자로만 이루어져 있는지 판별하는 함수
// fun isInteger(s: String): Boolean {
//     return try {
//         s.toInt()
//         true
//     } catch (e: Exception) {
//         false
//     }
// }

// fun main() {
//     // 호텔 예약 클래스 객체 생성
//     val hotelReservation = HotelReservation()
//     // 메뉴 선택을 저장하는 변수
//     var selectedMenu: String

//     while(true) {
//         // 초기 메세지
//         hotelReservation.initialMessage()
//         // 메뉴 선택
//         selectedMenu = readln()

//         // 변수값이 숫자인지 확인
//         // 아니라면 처음으로 이동
//         if (!isInteger(selectedMenu)) {
//             System.err.println("메뉴 입력은 숫자만 가능합니다.")
//             continue
//         }

//         // 선택된 메뉴에 따라서 함수 호출
//         when (selectedMenu.toInt()) {
//             1 -> hotelReservation.reservation()
//             2 -> hotelReservation.reservationList()
//             3 -> hotelReservation.reservationSortedList()
//             4 -> break
//             5 -> hotelReservation.feeList()
//             6 -> hotelReservation.changeReservation()
//         }
//     }
// }




// // 레벨1~레벨4 모두 포함
// fun main() {
//     val hotelReservation = HotelReservation()

//     hotelReservation.start()
// }

// class HotelReservation {
//     private var selectedMenu: Int = 0
//     private val reservationPersonList = mutableListOf<ReservationPerson>()
//     private val initialMoney = 100000

//     var name: String = ""
//     var roomNum: Int = 0
//     var checkIn: String = ""
//     var checkOut: String = ""
//     var money: Int = 0

//     fun start() {
//         while(true) {
//             initialMessage()
//             selectedMenu = readln().toInt()
//             if (selectedMenu == 4) return
//             selectMenu()
//         }
//     }

//     fun initialMessage() {
//         println("\n호텔예약 프로그램 입니다.")
//         println("[메뉴]")
//         println("1. 방예약, 2. 예약목록 출력 3. 예약목록 (정렬) 출력 4. 시스템 종료 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
//     }

//     fun selectMenu() {
//         when (selectedMenu) {
//             1 -> reservation()
//             2 -> reservationList()
//             3 -> reservationSortedList()
//             5 -> feeList()
//             6 -> changeReservation()
//         }
//     }

//     fun reservation() {
//         name = inputInfo("name").toString()
//         roomNum = inputInfo("roomNumber").toString().toInt()
//         checkIn = inputInfo("checkIn").toString()
//         checkOut = inputInfo("checkOut").toString()
//         println("호텔 예약이 완료되었습니다.")
//         money = initialMoney
//         val reservationFee = Random.nextInt(1000) * 10
//         money -= reservationFee
//         println("호텔 예약비 ${reservationFee}원이 빠져나갔습니다.")

//         reservationPersonList.add(ReservationPerson(name, roomNum, checkIn, checkOut, money))
//         println(reservationPersonList)
//         clearInfo()
//     }

//     private fun clearInfo() {
//         name = ""
//         roomNum = 0
//         checkIn = ""
//         checkOut = ""
//         money = 0
//     }

//     private fun reservationList() {
//         println("호텔 예약자 목록입니다.")
//         for (i in reservationPersonList.indices) {
//             val curName = reservationPersonList[i].name
//             val curRoomNum = reservationPersonList[i].roomNum
//             val curCheckIn = reservationPersonList[i].checkIn.substring(0..3) + "-" + reservationPersonList[i].checkIn.substring(4..5) + "-" + reservationPersonList[i].checkIn.substring(6..7)
//             val curCheckOut = reservationPersonList[i].checkOut.substring(0..3) + "-" + reservationPersonList[i].checkOut.substring(4..5) + "-" + reservationPersonList[i].checkOut.substring(6..7)
//             println("${i + 1}. 사용자: ${curName}, 방번호: ${curRoomNum}, 체크인: ${curCheckIn}, 체크아웃: ${curCheckOut}")
//         }
//     }
//     private fun reservationSortedList() {
//         val sortedReservationPersonList = reservationPersonList.sortedBy { it.checkIn }
//         println("호텔 예약자 목록입니다. (정렬완료)")
//         for (i in sortedReservationPersonList.indices) {
//             val curName = sortedReservationPersonList[i].name
//             val curRoomNum = sortedReservationPersonList[i].roomNum
//             val curCheckIn = sortedReservationPersonList[i].checkIn.substring(0..3) + "-" + sortedReservationPersonList[i].checkIn.substring(4..5) + "-" + sortedReservationPersonList[i].checkIn.substring(6..7)
//             val curCheckOut = sortedReservationPersonList[i].checkOut.substring(0..3) + "-" + sortedReservationPersonList[i].checkOut.substring(4..5) + "-" + sortedReservationPersonList[i].checkOut.substring(6..7)
//             println("${i + 1}. 사용자: ${curName}, 방번호: ${curRoomNum}, 체크인: ${curCheckIn}, 체크아웃: ${curCheckOut}")
//         }
//     }
//     private fun feeList() {
//         println("조회하실 사용자 이름을 입력하세요")
//         val findName = readln()
//         for (i in reservationPersonList.indices) {
//             if (findName == reservationPersonList[i].name) {
//                 println("1. 초기 금액으로 ${initialMoney}원 입금되었습니다.")
//                 println("2. 예약금으로 ${initialMoney - reservationPersonList[i].money}원 출금되었습니다.")
//                 return
//             }
//         }
//         println("예약된 사용자를 찾을수 없습니다.")
//     }
//     private fun changeReservation() {
//         println("예약을 변경할 사용자 이름을 입력하세요")
//         val changeName = readln()

//         while (true) {
//             var count = 1
//             val countIdx = mutableListOf<Int>()
//             for (i in reservationPersonList.indices) {
//                 if (changeName == reservationPersonList[i].name) {
//                     countIdx += i
//                     if (count == 1) println("${changeName}님이 예약한 목록입니다. 변경하실 예약번호를 입력해주세요 (탈출은 exit입력)")
//                     val changeRoomNum = reservationPersonList[i].roomNum
//                     val changeCheckIn = reservationPersonList[i].checkIn.substring(0..3) + "-" + reservationPersonList[i].checkIn.substring(4..5) + "-" + reservationPersonList[i].checkIn.substring(6..7)
//                     val changeCheckOut = reservationPersonList[i].checkOut.substring(0..3) + "-" + reservationPersonList[i].checkOut.substring(4..5) + "-" + reservationPersonList[i].checkOut.substring(6..7)
//                     println("${count++}. 방번호: ${changeRoomNum}, 체크인: ${changeCheckIn}, 체크아웃: ${changeCheckOut}")
//                 }
//             }

//             if (count == 1) break

//             val operation = readln()
//             if (operation == "exit") return
//             if (operation.toInt() >= count) {
//                 println("범위에 없는 예약번호입니다.")
//             } else {
//                 println("해당 예약을 어떻게 하시겠어요 1. 변경 2. 취소 / 이외 번호. 메뉴로 돌아가기")
//                 val decide = readln().toInt()
//                 when (decide) {
//                     1 -> {
//                         checkIn = inputInfo("checkIn").toString()
//                         checkOut = inputInfo("checkOut").toString()
//                         reservationPersonList[countIdx[operation.toInt() - 1]].checkIn = checkIn
//                         reservationPersonList[countIdx[operation.toInt() - 1]].checkOut = checkOut
//                         println("예약 변경이 완료되었습니다.")
//                         clearInfo()
//                         return
//                     }
//                     2 -> {
//                         println("[취소 유의사항]")
//                         println("체크인 3일 이전 취소 예약금 환불 불가")
//                         println("체크인 5일 이전 취소 예약금의 30% 환불")
//                         println("체크인 7일 이전 취소 예약금의 50% 환불")
//                         println("체크인 14일 이전 취소 예약금의 80% 환불")
//                         println("체크인 30일 이전 취소 예약금의 100% 환불")

//                         var today = LocalDate.now().toString().replace("-", "")
//                         var cancelCheckIn = reservationPersonList[countIdx[operation.toInt() - 1]].checkIn

//                         val sdf = SimpleDateFormat("yyyyMMdd")

//                         val cancelCheckInDate = sdf.parse(cancelCheckIn)?.time
//                         val todayDate = sdf.parse(today)?.time

//                         val diff = (cancelCheckInDate?.minus(todayDate!!))?.div((24*60*60*1000))
//                         when (diff?.toInt()) {
//                             in 0..3 -> println("결과 : 예약금 환불 불가")
//                             in 4..5 -> {
//                                 println("결과 : 예약금의 30% 환불")
//                                 println("${((initialMoney - reservationPersonList[countIdx[operation.toInt() - 1]].money) * 0.3).toInt()}원 환불")
//                             }
//                             in 6..7 -> {
//                                 println("결과 : 예약금의 50% 환불")
//                                 println("${((initialMoney - reservationPersonList[countIdx[operation.toInt() - 1]].money) * 0.5).toInt()}원 환불")
//                             }
//                             in 8..14 -> {
//                                 println("결과 : 예약금의 80% 환불")
//                                 println("${((initialMoney - reservationPersonList[countIdx[operation.toInt() - 1]].money) * 0.8).toInt()}원 환불")
//                             }
//                             in 15..30 -> {
//                                 println("결과 : 예약금의 100% 환불")
//                                 println("${(initialMoney - reservationPersonList[countIdx[operation.toInt() - 1]].money)}원 환불")
//                             }
//                             else -> {
//                                 println("결과 : 예약금의 100% 환불")
//                                 println("${(initialMoney - reservationPersonList[countIdx[operation.toInt() - 1]].money)}원 환불")
//                             }
//                         }
//                         reservationPersonList.removeAt(countIdx[operation.toInt() - 1])
//                         println("취소가 완료되었습니다.")
//                         return
//                     }
//                     else -> return
//                 }
//             }
//         }

//         println("예약된 사용자를 찾을수 없습니다.")
//     }

//     private fun inputInfo(type: String): Any? {
//         return when(type) {
//             "name" -> {
//                 println("예약자분의 성함을 입력해주세요")
//                 while (true) {
//                     try {
//                         return readln()
//                     } catch (e: Exception) {
//                         println("성함을 다시 입력해주세요")
//                     }
//                 }
//             }
//             "roomNumber" -> {
//                 while (true) {
//                     println("예약할 방번호를 입력해주세요")
//                     try {
//                         var inputRoomNumber = readln().toInt()
//                         if (inputRoomNumber in 100..999) {
//                             return inputRoomNumber
//                         } else {
//                             println("올바르지 않는 방번호입니다. 방번호는 100-999 영역 이내입니다.")
//                         }
//                     } catch (e: Exception) {
//                         println("올바르지 않는 방번호입니다. 방번호는 100-999 영역 이내입니다.")
//                     }
//                 }
//             }
//             "checkIn" -> {
//                 while (true) {
//                     println("체크인 날짜를 입력해주세요 표기형식. 20231201")
//                     try {
//                         var inputCheckIn = readln()
//                         var today = LocalDate.now().toString().replace("-", "")

//                         val sdf = SimpleDateFormat("yyyyMMdd")

//                         val checkInDate = sdf.parse(inputCheckIn)
//                         val todayDate = sdf.parse(today)

//                         if (checkInDate != null) {
//                             when {
//                                 checkInDate.after(todayDate) || checkInDate.equals(todayDate) -> {
//                                     if (!checkRoom(inputCheckIn)) {
//                                         return inputCheckIn
//                                     } else {
//                                         println("해당 날짜에 이미 방을 사용중입니다. 다른날짜를 입력해주세요")
//                                     }
//                                 }
//                                 checkInDate.before(todayDate) -> println("체크인은 지난날을 선택할 수 없습니다.")
//                             }
//                         } else {
//                             println("체크인 날짜를 다시 입력해주세요 표기형식. 20231201")
//                         }
//                     } catch (e: Exception) {
//                         println("체크인 날짜를 다시 입력해주세요 표기형식. 20231201")
//                     }
//                 }
//             }
//             "checkOut" -> {
//                 while (true) {

//                     println("체크아웃 날짜를 입력해주세요 표기형식. 20231201")
//                     try {
//                         var inputCheckOut = readln()

//                         val sdf = SimpleDateFormat("yyyyMMdd")

//                         val checkOutDate = sdf.parse(inputCheckOut)
//                         val checkInDate = sdf.parse(checkIn)

//                         if (checkOutDate != null) {
//                             when {
//                                 checkOutDate.after(checkInDate) -> return inputCheckOut
//                                 checkOutDate.before(checkInDate) -> println("체크아웃은 체크인보다 이전일 수 없습니다.")
//                                 checkOutDate.equals(checkInDate) -> println("체크아웃은 체크인과 같은 날일 수 없습니다.")
//                             }
//                         } else {
//                             println("체크아웃 날짜를 다시 입력해주세요 표기형식. 20231201")
//                         }
//                     } catch (e: Exception) {
//                         println(e)
//                         println("체크아웃1 날짜를 다시 입력해주세요 표기형식. 20231201")
//                     }
//                 }
//             }
//             else -> "invalid info"
//         }
//     }

//     private fun checkRoom(checkInDate: String): Boolean {
//         for (i in reservationPersonList.indices) {
//             if (reservationPersonList[i].roomNum == roomNum) {
//                 val sdf = SimpleDateFormat("yyyyMMdd")

//                 val leftDate = sdf.parse(reservationPersonList[i].checkIn)
//                 val rightDate = sdf.parse(reservationPersonList[i].checkOut)
//                 val targetDate = sdf.parse(checkInDate)

//                 if (targetDate != null) {
//                     return targetDate.after(leftDate) && targetDate.before(rightDate)
//                 }
//             }
//         }

//         return false
//     }
// }

// data class ReservationPerson(val name: String, var roomNum: Int, var checkIn: String, var checkOut: String, val money: Int)
