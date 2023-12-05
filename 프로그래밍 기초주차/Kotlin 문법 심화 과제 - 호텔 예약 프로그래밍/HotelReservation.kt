// 수정 버전 : 23.12.05

// 입력값의 타입을 지정하는 enum class
enum class Type {
    NAME, ROOMNUMBER, CHECKIN, CHECKOUT
}

class HotelReservation {
    // 날짜 포맷을 위한 DateTimeFormatter
    private val dtf: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    private val dtf2: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    // 호텔 예약한 인원들에 대한 정보가 담겨있는 리스트
    private val reservationPersonList = mutableListOf<ReservationPerson>()

    // 예약에 필요한 정보들을 미리 선언 및 초기화
    var name: String = ""
    var roomNum: Int = 0
    var checkIn: String = ""
    var checkOut: String = ""
    var money: Int = 0

    // 초기 메세지
    fun initialMessage() {
        println("\n호텔예약 프로그램 입니다.")
        println("[메뉴]")
        println("1. 방예약, 2. 예약목록 출력 3. 예약목록 (정렬) 출력 4. 시스템 종료 5. 금액 입금-출금 내역 목록 출력 6. 예약 변경/취소")
    }

    // 예약 구현
    fun reservation() {
        // 인원들의 초기금
        val initialMoney = (10000..50000).random()
        // 예약금 랜덤으로 정해짐
        val reservationFee = Random.nextInt(1000) * 10

        // 필요한 예약 정보 받아오기
        // checkOut을 구할 때 조건으로 checkIn 변수가 필요해서 지역변수가 아닌 class의 변수로 설정하는 방식으로 구현
        name = inputInfo(Type.NAME).toString()
        roomNum = inputInfo(Type.ROOMNUMBER).toString().toInt()
        checkIn = inputInfo(Type.CHECKIN).toString()
        checkOut = inputInfo(Type.CHECKOUT).toString()
        money = initialMoney - reservationFee

        // 예약 명단 리스트에 ReservationPerson 타입으로 저장
        reservationPersonList.add(ReservationPerson(name, roomNum, checkIn, checkOut, money, reservationFee))
        println("호텔 예약이 완료되었습니다.")
        println("호텔 예약비 ${reservationFee}원이 빠져나갔습니다.")

        // 다음 사람을 위해 정보 정리
        clearInfo()
    }

    // 예약 정보 초기화하는 함수
    private fun clearInfo() {
        name = ""
        roomNum = 0
        checkIn = ""
        checkOut = ""
        money = 0
    }

    // 예약 명단 보여주는 함수
    fun reservationList() {
        println("호텔 예약자 목록입니다.")
        reservationPersonList.forEachIndexed { index, person ->
            println("${index + 1}. 사용자: ${person.name}, " +
                    "방번호: ${person.roomNum}, " +
                    // yyyyMMdd 형태의 문자열을 Date 형태로 바꾸고(parse) 그걸 다시 yyyy-MM-dd 형태로 변경(format)
                    "체크인: ${LocalDate.from(dtf.parse(person.checkIn)).format(dtf2)}, " +
                    "체크아웃: ${LocalDate.from(dtf.parse(person.checkOut)).format(dtf2)}")
        }
    }

    // 체크인에 대해 오름차순으로 정렬된 예약 명단 보여주는 함수
    fun reservationSortedList() {
        // 체크인에 대해 오름차순으로 정렬
        val sortedReservationPersonList = reservationPersonList.sortedBy { it.checkIn }
        println("호텔 예약자 목록입니다. (정렬완료)")
        sortedReservationPersonList.forEachIndexed { index, person ->
            println("${index + 1}. 사용자: ${person.name}, " +
                    "방번호: ${person.roomNum}, " +
                    // yyyyMMdd 형태의 문자열을 Date 형태로 바꾸고(parse) 그걸 다시 yyyy-MM-dd 형태로 변경(format)
                    "체크인: ${LocalDate.from(dtf.parse(person.checkIn)).format(dtf2)}, " +
                    "체크아웃: ${LocalDate.from(dtf.parse(person.checkOut)).format(dtf2)}")
        }
    }

    // 금액 관련 출력 함수
    fun feeList() {
        println("조회하실 사용자 이름을 입력하세요")
        val findName = readln()
        reservationPersonList.forEach {
            if (findName == it.name) {
                println("1. 초기 금액으로 ${it.money + it.reservationFee}원 입금되었습니다.")
                println("2. 예약금으로 ${it.reservationFee}원 출금되었습니다.")
                return
            }
        }
        println("예약된 사용자를 찾을수 없습니다.")
    }

    // 예약 변경 및 취소 함수
    fun changeReservation() {
        println("예약을 변경할 사용자 이름을 입력하세요")
        val changeName = readln()

        while (true) {
            // 한 사람이 여러번 예약했을 경우를 위한 변수
            var count = 1
            // 조건에 맞는 예약 명단 리스트의 인덱스를 저장해놓기 위한 리스트
            val countIdx = mutableListOf<Int>()
            reservationPersonList.forEachIndexed { index, person ->
                // 같은 이름이 있는 경우
                if (changeName == person.name) {
                    // 저장해두고
                    countIdx += index
                    // 처음에만 이 출력문이 나오도록 세팅
                    if (count == 1) println("${changeName}님이 예약한 목록입니다. 변경하실 예약번호를 입력해주세요 (탈출은 exit입력)")
                    println("${count++}. 방번호: ${person.roomNum}, 체크인: ${LocalDate.from(dtf.parse(person.checkIn)).format(dtf2)}, 체크아웃: ${LocalDate.from(dtf.parse(person.checkOut)).format(dtf2)}")
                }
            }

            // 반복문을 통과했는데도 count가 1이라는 건 하나의 예약도 존재하지 않는다는 것
            if (count == 1) {
                println("예약 목록이 존재하지 않습니다.")
                break
            }

            // 변경할 예약변호 입력하는 곳
            val operation = readln()
            // exit이 입력되었다면 다시 처음 화면으로
            if (operation == "exit") return

            // 현재 목록으로 떠 있는 숫자의 범위에서 벗어난 숫자를 입력한 경우
            if (operation.toInt() >= count || operation.toInt() < 1) {
                println("범위에 없는 예약번호입니다.")
            } else {
                println("해당 예약을 어떻게 하시겠어요 1. 변경 2. 취소 / 이외 번호. 메뉴로 돌아가기")
                // 예약 변경 또는 예약 취소를 시작
                when (readln().toInt()) {
                    1 -> {
                        // 다시 체크인 날짜와 체크아웃 날짜를 받고
                        checkIn = inputInfo(Type.CHECKIN).toString()
                        checkOut = inputInfo(Type.CHECKOUT).toString()
                        // 미리 저장해둔 인덱스를 이용해서 수정
                        reservationPersonList[countIdx[operation.toInt() - 1]].checkIn = checkIn
                        reservationPersonList[countIdx[operation.toInt() - 1]].checkOut = checkOut
                        println("예약 변경이 완료되었습니다.")
                        // 다음 사람을 위해 정보 정리
                        clearInfo()
                        return
                    }
                    2 -> {
                        println("[취소 유의사항]")
                        println("체크인 3일 이전 취소 예약금 환불 불가")
                        println("체크인 5일 이전 취소 예약금의 30% 환불")
                        println("체크인 7일 이전 취소 예약금의 50% 환불")
                        println("체크인 14일 이전 취소 예약금의 80% 환불")
                        println("체크인 30일 이전 취소 예약금의 100% 환불")

                        val curPerson = reservationPersonList[countIdx[operation.toInt() - 1]]
                        val todayDate = LocalDate.now()
                        // 체크인하는 날
                        val cancelCheckIn = curPerson.checkIn
                        val cancelCheckInDate = LocalDate.from(dtf.parse(cancelCheckIn))
                        // 오늘부터 체크인날까지의 차이를 구함
                        val diff = Duration.between(todayDate.atStartOfDay(), cancelCheckInDate.atStartOfDay())
                        // 예약금
                        val reservationFee = curPerson.reservationFee
                        // 오늘부터 체크인 날까지의 차이로 정해지는 예약금 환불
                        when (diff.toDays().toInt()) {
                            in 0..3 -> println("결과 : 예약금 환불 불가")
                            in 4..5 -> {
                                println("결과 : 예약금의 30% 환불")
                                println("${(reservationFee * 0.3).toInt()}원 환불")
                            }
                            in 6..7 -> {
                                println("결과 : 예약금의 50% 환불")
                                println("${(reservationFee * 0.5).toInt()}원 환불")
                            }
                            in 8..14 -> {
                                println("결과 : 예약금의 80% 환불")
                                println("${(reservationFee * 0.8).toInt()}원 환불")
                            }
                            else -> {
                                println("결과 : 예약금의 100% 환불")
                                println("${reservationFee}원 환불")
                            }
                        }
                        // 미리 저장해둔 인덱스를 이용하여 예약 명단 리스트에서 제거
                        reservationPersonList.removeAt(countIdx[operation.toInt() - 1])
                        println("취소가 완료되었습니다.")
                        return
                    }
                }
            }
        }
        println("예약된 사용자를 찾을수 없습니다.")
    }



    private fun inputInfo(type: Type): Any {
        return when (type) {
            // 이름을 받는 곳
            Type.NAME -> {
                println("예약자분의 성함을 입력해주세요")
                while (true) {
                    try {
                        // 이름 return
                        return readln()
                    } catch (e: Exception) {
                        println("성함을 다시 입력해주세요")
                    }
                }
            }
            // 방 번호를 받는 곳
            Type.ROOMNUMBER -> {
                while (true) {
                    println("예약할 방번호를 입력해주세요")
                    try {
                        var inputRoomNumber = readln().toInt()
                        if (inputRoomNumber in 100..999) {
                            // 조건에 해당할 때 방 번호 return
                            return inputRoomNumber
                        } else {
                            println("올바르지 않는 방번호입니다. 방번호는 100-999 영역 이내입니다.")
                        }
                    } catch (e: Exception) {
                        println("올바르지 않는 방번호입니다. 방번호는 100-999 영역 이내입니다.")
                    }
                }
            }
            // 체크인 날짜 받는 곳
            Type.CHECKIN -> {
                while (true) {
                    println("체크인 날짜를 입력해주세요 표기형식. 20231201")
                    try {
                        var inputCheckIn = readln()
                        val checkInDate = LocalDate.from(dtf.parse(inputCheckIn))

                        if (checkInDate.isBefore(LocalDate.now())) {
                            println("체크인은 지난날은 선택할 수 없습니다.")
                            continue
                        }

                        if (!checkRoom(checkInDate)) {
                            // 조건에 맞을 때 체크인 날짜 return
                            return inputCheckIn
                        } else {
                            println("해당 날짜에 이미 방을 사용중입니다. 다른날짜를 입력해주세요")
                            continue
                        }
                    } catch (e: DateTimeException) {
                        System.err.println("올바르지 않은 포맷입니다 다시 입력해주세요")
                        continue
                    }
                }
            }
            // 체크아웃 날짜 받는 곳
            Type.CHECKOUT -> {
                while (true) {
                    println("체크아웃 날짜를 입력해주세요 표기형식. 20231201")
                    try {
                        var inputCheckOut = readln()
                        val checkOutDate = LocalDate.from(dtf.parse(inputCheckOut))
                        val checkInDate = LocalDate.from(dtf.parse(checkIn))
                        if (checkOutDate.isBefore(checkInDate) || checkOutDate.isEqual(checkInDate)) {
                            println("체크인 날짜보다 이전이거나 같을 수는 없습니다.")
                            continue
                        }

                        if (!checkRoom(checkOutDate)) {
                            // 조건에 맞을 때 체크인 날짜 return
                            return inputCheckOut
                        } else {
                            println("해당 날짜에 이미 방을 사용중입니다. 다른날짜를 입력해주세요")
                            continue
                        }
                    } catch (e: Exception) {
                        System.err.println("올바르지 않은 포맷입니다 다시 입력해주세요")
                        continue
                    }
                }
            }
        }
    }

    // 선택한 날짜에 해당 방이 사용 예정이거나 사용 중인지 확인하는 함수
    private fun checkRoom(date: LocalDate): Boolean {
        reservationPersonList.forEach {
            if (it.roomNum == roomNum) {
                val leftDate = LocalDate.from(dtf.parse(it.checkIn))
                val rightDate = LocalDate.from(dtf.parse(it.checkOut))

                return date.isAfter(leftDate) && date.isBefore(rightDate)
            }
        }
        return false
    }
}
