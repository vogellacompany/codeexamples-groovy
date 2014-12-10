package l600_MetaObjectProtocol

class SensitiveService {

    int numberOfNukes = 0

    String nukeCity(String username, String city) {
        numberOfNukes++
        return "$username has ordered to nuke $city. Nuking..."
    }

}
