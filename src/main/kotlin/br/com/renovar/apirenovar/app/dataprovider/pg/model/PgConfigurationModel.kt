package br.com.renovar.apirenovar.app.dataprovider.pg.model

import br.com.renovar.apirenovar.app.commons.BaseModel
import br.com.renovar.apirenovar.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Parameter
import java.time.DayOfWeek
import javax.persistence.*

@Entity
@Table(name = "pg_configuration")
class PgConfigurationModel(
    @Id
    @GenericGenerator(name = "PgConfigurationGenerator", strategy = "br.com.renovar.apirenovar.base.PostgreSequenceStrategy", parameters = [
        Parameter(value = "pg_configuration_seq", name = "sequence")
    ])
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PgConfigurationGenerator")
    var id: Long = 0,
    @OneToOne(mappedBy = "configuration")
    @JsonBackReference
    var pg: PgModel?,
    @Column(name = "day_of_week") var dayOfWeek: Int = DayOfWeek.MONDAY.value,
    var address: String = "",
    @Column(name = "image_id")var imageId: String? = null
): BaseModel