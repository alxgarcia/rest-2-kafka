import org.apache.kafka.clients.admin.AdminClient
import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic

fun main() {
    val client = AdminClient.create(mapOf(
        AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG to "localhost:9092",
        AdminClientConfig.CLIENT_ID_CONFIG to "test-admin-client",
    ))

    runCatching { client.createTopics(listOf(NewTopic("topic", 1, 1))).all().get() }
}