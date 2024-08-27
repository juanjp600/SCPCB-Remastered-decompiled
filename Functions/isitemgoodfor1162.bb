Function isitemgoodfor1162%(arg0.itemtemplates)
    Local local0$
    local0 = arg0\Field1
    Select arg0\Field1
        Case "key0","key1","key2","key3"
            Return $01
        Case "misc","scp420j","cigarette"
            Return $01
        Case "vest","finevest","gasmask","helmet"
            Return $01
        Case "radio","18vradio"
            Return $01
        Case "clipboard","eyedrops","eyedrops2","nvgoggles","minteyedrops","minteyedrops2"
            Return $01
        Case "scp198","scp357"
            Return $01
        Case "drawing"
            If (arg0\Field11 <> $00) Then
                freeimage(arg0\Field11)
            EndIf
            arg0\Field11 = loadimage_strict(scpmodding_processfilepath((("GFX\items\1048\1048_" + (Str rand($01, $19))) + ".jpg")))
            Return $01
        Default
            If (arg0\Field1 <> "paper") Then
                Return $00
            ElseIf (instr(arg0\Field0, "Leaflet", $01) <> 0) Then
                Return $00
            Else
                Return ((instr(arg0\Field0, "Note", $01) = $00) And (instr(arg0\Field0, "Log", $01) = $00))
            EndIf
    End Select
    Return $00
End Function
