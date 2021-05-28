package com.mobile.myappneon.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
internal data class Transferencia (
  val id: Int,
  val nome: String,
  val telefone: String,
  val foto: String,
  val valor: String
): Parcelable