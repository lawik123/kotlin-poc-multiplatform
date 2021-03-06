package nl.lawik.poc.multiplatform.endpoint

import io.ktor.client.request.get
import io.ktor.client.request.post
import nl.lawik.poc.multiplatform.*
import nl.lawik.poc.multiplatform.dto.PersonDTO

actual class PersonEndpoint : Endpoint(PersonPaths.ROOT) {
    actual suspend fun getById(id: Long): PersonDTO = client.get {
        setPath(PersonPaths.getByIdPath(id))
    }

    actual suspend fun getAll(): List<PersonDTO> = client.list {
        setPath()
    }

    actual suspend fun getAllResultsList(): ResultsList<PersonDTO> = client.resultsList {
        setPath(PersonPaths.RESULTS_LIST_PATH)
    }

    actual suspend fun create(personDTO: PersonDTO): Long = client.post {
        setPath()
        json(personDTO)
    }
}

