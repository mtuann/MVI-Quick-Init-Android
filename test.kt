sealed class InterpretationViewTool(val imageView: ImageView?, val isLongClicked: Boolean=false) {
    // isLongClicked: false: onClick,
    data class OnClickNoAction(val imageView: ImageView?, val isLongClicked: Boolean=false): InterpretationViewTool() // default Tool
    data class OnClickZooming(val imageView: ImageView?,val isLongClicked: Boolean=false): InterpretationViewTool()
    data class OnClickDrawPoint(val imageView: ImageView?,val keyDrawPoint: String="point", val isLongClicked: Boolean=false): InterpretationViewTool()
    data class OnClickDrawBoundary(val imageView: ImageView?,val keyDrawBoundary: String="boundary", val isLongClicked: Boolean=false): InterpretationViewTool()
    data class OnClickMeasureLength(val imageView: ImageView?,val keyMearureLength: String="length", val isLongClicked: Boolean=false): InterpretationViewTool()
    data class OnClickMeasureArea(val imageView: ImageView?,val keyMeasureArea: String="area", val isLongClicked: Boolean=false): InterpretationViewTool()
    data class OnClickCalculateEF(val imageView: ImageView?,val isLongClicked: Boolean=false): InterpretationViewTool()
    data class OnClickShowBullEye(val imageView: ImageView?,val isLongClicked: Boolean=false): InterpretationViewTool()
}