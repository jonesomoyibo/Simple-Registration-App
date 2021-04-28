package com.decagon.jones.weekfivetask

import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Test
import com.google.common.truth.Truth.*
import org.junit.Before

class RegistrationActivityTest {





    @Test
    public fun phoneNumberStartWith0Or234(){

        Truth.assertThat(ViewValidator.phoneNumberValidator("18168105123")).isTrue()
    }

    @Test
    public fun phoneNumberStartWith0AndEquals11(){

        Truth.assertThat(ViewValidator.phoneNumberValidator("08168105123")).isTrue()
    }

    @Test
    public fun phoneNumberStartWith234AndEquals13(){

        Truth.assertThat(ViewValidator.phoneNumberValidator("2348168105123")).isTrue()
    }
    @Test
    public fun phoneNumberDigitsNotEqualTo110r13(){

        Truth.assertThat(ViewValidator.phoneNumberValidator("08168105123")).isTrue()
    }

}

