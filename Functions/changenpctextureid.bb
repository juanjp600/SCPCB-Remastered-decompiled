Function changenpctextureid%(arg0.npcs, arg1%)
    Local local0.objects
    Local local1#
    local0 = (First objects)
    If (arg0 = Null) Then
        createconsolemsg("Tried to change the texture of an invalid NPC", $FFFFFFFF, $FFFFFFFF, $FFFFFFFF, $00)
        If (consoleopening <> 0) Then
            consoleopen = $01
        EndIf
        Return $00
    EndIf
    arg0\Field69 = (arg1 + $01)
    freeentity(arg0\Field0)
    arg0\Field0 = copyentity(dtextures[(arg1 + $01)], $00)
    local1 = (0.5 / meshwidth(arg0\Field0))
    scaleentity(arg0\Field0, local1, local1, local1, $00)
    meshcullbox(arg0\Field0, (- meshwidth(local0\Field0[$03])), (- meshheight(local0\Field0[$03])), (- meshdepth(local0\Field0[$03])), (meshwidth(local0\Field0[$03]) * 2.0), (meshheight(local0\Field0[$03]) * 2.0), (meshdepth(local0\Field0[$03]) * 2.0))
    setnpcframe(arg0, arg0\Field14)
    Return $00
End Function
