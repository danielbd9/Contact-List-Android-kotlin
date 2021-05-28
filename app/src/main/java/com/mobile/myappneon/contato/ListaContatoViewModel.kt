package com.mobile.myappneon.contato

import androidx.lifecycle.ViewModel
import com.mobile.myappneon.model.Contato

internal class ListaContatoViewModel : ViewModel(){

    fun inicializarListaContatos(): List<Contato>{
        return listOf(contato1(),contato2(),contato3(),contato4(),contato5(),
                contato6(),contato7(),contato8(),contato9(),contato10(),
                contato11(),contato12(),contato13(),contato14(),contato15())
    }

    private fun contato1() : Contato {
        return Contato(
                1,
                "Contato1",
                "(31)91999-9999",
                "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-4-avatar-2754580_120522.png"
        )
    }

    private fun contato2() : Contato {
        return Contato(
                2,
                "Contato2",
                "(31)92999-9999",
                "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-11-avatar-2754576_120520.png"
        )
    }

    private fun contato3() : Contato {
        return Contato(
                3,
                "Contato3",
                "(31)93999-9999",
                "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-10-avatar-2754575_120521.png"
        )
    }

    private fun contato4() : Contato {
        return Contato(
                4,
                "Contato4",
                "(31)94999-9999",
                "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-5-avatar-2754581_120512.png"
        )
    }

    private fun contato5() : Contato {
        return Contato(
                5,
                "Contato5",
                "(31)95999-9999",
                "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-11-avatar-2754576_120520.png"
        )
    }

    private fun contato6() : Contato {
        return Contato(
                6,
                "Contato6",
                "(31)96999-9999",
                ""
        )
    }

    private fun contato7() : Contato {
        return Contato(
                7,
                "Contato7",
                "(31)97999-9999",
                "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-2-avatar-2754578_120514.png"
        )
    }

    private fun contato8() : Contato {
        return Contato(
                8,
                "Contato8",
                "(31)98999-9999",
                "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-5-avatar-2754581_120512.png"
        )
    }

    private fun contato9() : Contato {
        return Contato(
                9,
                "Contato9",
                "(31)99999-9999",
                "https://cdn.iconscout.com/icon/free/png-512/avatar-373-456325.png"
        )
    }

    private fun contato10() : Contato {
        return Contato(
                10,
                "Contato10",
                "(31)90999-9999",
                "https://cdn.icon-icons.com/icons2/1879/PNG/512/iconfinder-10-avatar-2754575_120521.png"
        )
    }

    private fun contato11() : Contato {
        return Contato(
                11,
                "Contato11",
                "(31)90999-9999",
                ""
        )
    }

    private fun contato12() : Contato {
        return Contato(
                12,
                "Contato12",
                "(31)92999-9999",
                ""
        )
    }

    private fun contato13() : Contato {
        return Contato(
                13,
                "Contato13",
                "(31)93999-9999",
                ""
        )
    }

    private fun contato14() : Contato {
        return Contato(
                14,
                "Contato14",
                "(31)94999-9999",
                ""
        )
    }

    private fun contato15() : Contato {
        return Contato(
                15,
                "Contato15",
                "(31)95999-9999",
                ""
        )
    }
}