package com.example.knitting

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Designations() {
    Column(
        Modifier
    ) {
        val desList = listOf(
            Designation("Символ/Symbol"),
            Designation("US Crochet term"),
            Designation("Обозначение"),

            Image(ImageBitmap.imageResource(R.drawable.des_1_start)),
            Designation("Start"),
            Designation("Начало вязания"),

            Image(ImageBitmap.imageResource(R.drawable.des_2_end)),
            Designation("End"),
            Designation("Конец вязания"),

            Image(ImageBitmap.imageResource(R.drawable.des_3_ch)),
            Designation("ch, chain stitch"),
            Designation("в.п., воздушная петля, петля, цепочка из петель"),

            Image(ImageBitmap.imageResource(R.drawable.des_4_slst)),
            Designation("sl st, ss, slip stitch"),
            Designation("соединительная или слепая петля"),

            Image(ImageBitmap.imageResource(R.drawable.des_5_ring)),
            Designation("Magic Ring"),
            Designation("скользящая или волшебная петля, кольцо амигуруми"),

            Image(ImageBitmap.imageResource(R.drawable.des_6_sc)),
            Designation("sc, single crochet"),
            Designation("СБН, столбик без накида"),

            Image(ImageBitmap.imageResource(R.drawable.des_7_sc_blo)),
            Designation("sc-blo or blp, single crochet in back loop only"),
            Designation("столбик без накида за заднюю стенку (полупетлю)"),

            Image(ImageBitmap.imageResource(R.drawable.des_8_esc)),
            Designation("esc or edc (EN), extended single crochet"),
            Designation("удлиненный (продленный) столбик без накида"),

            Image(ImageBitmap.imageResource(R.drawable.des_9_solomon_knot)),
            Designation("solomon’s-knot, solomon’s stitch"),
            Designation("Соломонова петля, Соломонов узел"),

            Image(ImageBitmap.imageResource(R.drawable.des_10_hdc)),
            Designation("hdc, half double crochet"),
            Designation("полустолбик с накидом"),

            Image(ImageBitmap.imageResource(R.drawable.des_11_hdc_blo)),
            Designation("hdc-blo, half double crochet in back loop only"),
            Designation("полустолбик за заднюю стенку (полупетлю)"),

            Image(ImageBitmap.imageResource(R.drawable.des_12_dc)),
            Designation("dc, double crochet"),
            Designation("ССН, столбик с накидом"),

            Image(ImageBitmap.imageResource(R.drawable.des_13_dc_blo)),
            Designation("dc-blo, double crochet in back loop only"),
            Designation("столбик с накидом за заднюю стенку (полупетлю)"),

            Image(ImageBitmap.imageResource(R.drawable.des_14_tr)),
            Designation("tr, treble croche"),
            Designation("СС2Н или С2Н, столбик с двумя накидами"),

            Image(ImageBitmap.imageResource(R.drawable.des_15_dtr)),
            Designation("dtr, double treble crochet"),
            Designation("СС3Н или С3Н, столбик с тремя накидами"),

            Image(ImageBitmap.imageResource(R.drawable.des_16_ddtc)),
            Designation("ddtc or trtr, double double treble crochet or treble treble crochet"),
            Designation("СС4Н или С4Н, столбик с четырьмя накидами"),

            Image(ImageBitmap.imageResource(R.drawable.des_17_sc2tog)),
            Designation("sc2tog, single crochet 2 together"),
            Designation("2 столбика без накида с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_18_sc3tog)),
            Designation("sc3tog, single crochet 3 together"),
            Designation("3 столбика без накида с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_19_sc4tog)),
            Designation("sc4tog, single crochet 4 together"),
            Designation("4 столбика без накида с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_20_hdc2tog)),
            Designation("hdc2tog, half double crochet 2 together"),
            Designation("2 полустолбика с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_21_dc2tog)),
            Designation("dc2tog, double crochet 2 together"),
            Designation("2 столбика с накидом с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_22_dc3tog)),
            Designation("dc3tog, double crochet 3 together"),
            Designation("3 столбика с накидом с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_23_dc4tog)),
            Designation("dc4tog, double crochet 4 together"),
            Designation("4 столбика с накидом с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_24_dc5tog)),
            Designation("dc5tog, double crochet 5 together"),
            Designation("5 столбиков с накидом с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_25_2_sc_in_1_st)),
            Designation("2 sc in 1 st"),
            Designation("2 столбика без накида с общим основанием"),

            Image(ImageBitmap.imageResource(R.drawable.des_26_3_sc_in_1_st)),
            Designation("3 sc in 1 st"),
            Designation("3 столбика без накида с общим основанием"),

            Image(ImageBitmap.imageResource(R.drawable.des_27_2_hdc_in_1_st)),
            Designation("2 hdc in 1 st"),
            Designation("2 полустолбика с общим основанием"),

            Image(ImageBitmap.imageResource(R.drawable.des_28_3_hdc_in_1_st)),
            Designation("3 hdc in 1 st"),
            Designation("3 полустолбика с общим основанием"),

            Image(ImageBitmap.imageResource(R.drawable.des_29_2_dc_in_1_st)),
            Designation("2 dc in 1 st"),
            Designation("2 столбика с накидом с общим основанием"),

            Image(ImageBitmap.imageResource(R.drawable.des_30_3_dc_in_1_st)),
            Designation("3 dc in 1 st"),
            Designation("3 столбика с накидом с общим основанием"),

            Image(ImageBitmap.imageResource(R.drawable.des_31_4_dc_in_1_st)),
            Designation("4 dc in 1 st"),
            Designation("4 столбика с накидом с общим основанием"),

            Image(ImageBitmap.imageResource(R.drawable.des_32_5_dc_shell)),
            Designation("5-dc shell, 5 dc in same stitch (shell)"),
            Designation("ракушка из 5-ти столбиков с накидом"),

            Image(ImageBitmap.imageResource(R.drawable.des_33_fpsc)),
            Designation("FPsc, Front Post single crochet"),
            Designation("лицевой (выпуклый) рельефный столбик без накида"),

            Image(ImageBitmap.imageResource(R.drawable.des_34_fphdc)),
            Designation("FPhdc, Front Post half double crochet"),
            Designation("лицевой (выпуклый) рельефный полустолбик"),

            Image(ImageBitmap.imageResource(R.drawable.des_35_fpdc)),
            Designation("FPdc, Front Post double crochet"),
            Designation("лицевой (выпуклый) рельефный столбик с одним накидом"),

            Image(ImageBitmap.imageResource(R.drawable.des_36_fptr)),
            Designation("FPtr, Front Post treble crochet"),
            Designation("лицевой (выпуклый) рельефный столбик с двумя накидами"),

            Image(ImageBitmap.imageResource(R.drawable.des_37_bpsc)),
            Designation("BPsc, Back Post single crochet"),
            Designation("изнаночный (вогнутый) рельефный столбик без накида"),

            Image(ImageBitmap.imageResource(R.drawable.des_38_bphdc)),
            Designation("BPhdc, Back Post half double crochet"),
            Designation("изнаночный (вогнутый) рельефный полустолбик"),

            Image(ImageBitmap.imageResource(R.drawable.des_39_bpdc)),
            Designation("BPdc, Back Post double crochet"),
            Designation("изнаночный (вогнутый) рельефный столбик с одним накидом"),

            Image(ImageBitmap.imageResource(R.drawable.des_40_bptr)),
            Designation("BPtr, Back Post treble crochet"),
            Designation("изнаночный (вогнутый) рельефный столбик с двумя накидами"),

            Image(ImageBitmap.imageResource(R.drawable.des_41_fpdc2tog)),
            Designation("FPdc2tog, Front Post double crochet 2 together"),
            Designation("2 лицевых (выпуклых) рельефных столбика с одним накидом с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_42_fptr2tog)),
            Designation("FPtr2tog, Front Post treble crochet 2 together"),
            Designation("2 лицевых (выпуклых) рельефных столбика с двумя накидами с общей вершиной"),

            Image(ImageBitmap.imageResource(R.drawable.des_43_puff)),
            Designation("puff stitch of 3 hdc"),
            Designation("пышный столбик из 3-х полустолбиков"),

            Image(ImageBitmap.imageResource(R.drawable.des_44_puff3dc)),
            Designation("puff stitch of 3 dc"),
            Designation("пышный столбик из 3-х столбиков с накидом"),

            Image(ImageBitmap.imageResource(R.drawable.des_45_2dc_cluster)),
            Designation("2 dc cluster"),
            Designation("2 столбика с накидом с общей вершиной из одной точки (кластер)"),

            Image(ImageBitmap.imageResource(R.drawable.des_46_3dc_cluster)),
            Designation("3 dc cluster"),
            Designation("3 столбика с накидом с общей вершиной из одной точки (кластер)"),

            Image(ImageBitmap.imageResource(R.drawable.des_47_5_dc_popcorn)),
            Designation("5-dc popcorn"),
            Designation("попкорн (шишечка)"),

            Image(ImageBitmap.imageResource(R.drawable.des_48_3dtr_cluster_v)),
            Designation("3dtr-cluster-v"),
            Designation("3 столбика с тремя накидами с общей вершиной из одной точки"),

            Image(ImageBitmap.imageResource(R.drawable.des_49_2tr_cluster)),
            Designation("2 tr cluster"),
            Designation("2 столбика с двумя накидами с общей вершиной из одной точки (кластер)"),

            Image(ImageBitmap.imageResource(R.drawable.des_50_picot_sc)),
            Designation("ch-3 picot, picot"),
            Designation("пико из трех петель"),

            Image(ImageBitmap.imageResource(R.drawable.des_51_y_st)),
            Designation("y-st"),
            Designation("2 столбика с накидом на ножке в верх (Y-столбик)"),

            Image(ImageBitmap.imageResource(R.drawable.des_52_inverted_y_st)),
            Designation("inverted y-st"),
            Designation("2 столбика с накидом на ножке в вниз (инверсный/перевернутый Y-столбик)"),

            Image(ImageBitmap.imageResource(R.drawable.des_53_dc_dc_crossed_1ch)),
            Designation("dc dc crossed with 1 ch"),
            Designation("сложный скрещенный столбик с одной воздушной петлей в вершине"),

            Image(ImageBitmap.imageResource(R.drawable.des_54_dc_dc_crossed)),
            Designation("dc dc crossed"),
            Designation("сложный скрещенный столбик"),
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
        ) {
            itemsIndexed(desList) { index, item ->

                if (index == 0 || index == 1 || index == 2) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .border(width = 1.dp, color = Color.Gray)
                    ) {
                        when (item) {
                            is Designation -> {
                                Text(
                                    item.text,
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    fontStyle = FontStyle.Italic,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }

                            else -> {}
                        }
                    }
                } else {
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier
                            .height(190.dp)
                            .border(width = 1.dp, color = Color.Gray)
                    ) {
                        when (item) {
                            is Designation -> {
                                Text(
                                    item.text,
                                    fontSize = 20.sp,
                                    modifier = Modifier
                                        .padding(5.dp)
                                )
                            }

                            is Image -> {
                                Image(
                                    bitmap = item.imageBitmap,
                                    contentDescription = "image",
                                    modifier = Modifier
                                        .size(70.dp)
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

data class Designation(val text: String)
data class Image(val imageBitmap: ImageBitmap)

@Preview(showBackground = true)
@Composable
fun DesignationsPreview() {
    Designations()
}