import java
Weld = java.type('org.jboss.weld.environment.se.Weld')
NumberApi = java.type('com.radcortez.graalvm.microprofile.number.api.client.NumberResourceApi')

weld = Weld()
container = weld.initialize()
numberApi = container.select(NumberApi).get()

print(numberApi.getNumber())
