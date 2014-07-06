package nebula.plugin.responsible

import spock.lang.Specification

class NebulaMetadataPluginSpec extends Specification {

    NebulaMetadataPlugin plugin

    def setup() {
        this.plugin = new NebulaMetadataPlugin()
    }

    void "passes valid name"() {
        expect:
        "validName" == plugin.scrubElementName("validName")
    }

    void "replace dots with underscores"() {
        expect:
        "nebula_Foo" == plugin.scrubElementName("nebula.Foo")
    }

    void "replace dashes with underscores"() {
        expect:
        "nebula_Foo" == plugin.scrubElementName("nebula-Foo")
    }

    void "removes spaces"() {
        expect:
        "nebulaFoo" == plugin.scrubElementName("nebula Foo")
    }

    void "trims string"() {
        expect:
        "nebula_Foo_BarStuff" == plugin.scrubElementName(" nebula.Foo-Bar Stuff ")
    }
}
