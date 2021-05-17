package br.com.renovar.apirenovar.dtos

class ChurchResponseDto(
    var id: Long = 0,
    var name: String = "",
    var email: String = "",
    var cnpj: String = "",
    var phone: String = "",
    var pastorName: String = "",
    var address: String = "",
    var city: CityWithoutDistrictsResponseDto
)