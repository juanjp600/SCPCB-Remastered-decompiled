Function drawcredits%()
    Local local0.fonts
    Local local1#
    Local local2.creditsline
    Local local3%
    Local local4%
    Local local5.creditsline
    Local local6.fps_settings
    local0 = (First fonts)
    local1 = (((i_end\Field0 + 2000.0) / 2.0) + (Float (graphicheight + $0A)))
    local6 = (First fps_settings)
    cls()
    If (rand($01, $12C) > $01) Then
        drawimage(creditsscreen, ((graphicwidth Sar $01) - $190), ((graphicheight Sar $01) - $190), $00)
    EndIf
    local3 = $00
    local4 = $00
    local5 = Null
    color($FF, $FF, $FF)
    For local2 = Each creditsline
        local2\Field1 = local3
        If (left(local2\Field0, $01) = "*") Then
            setfont(local0\Field2[$01])
            If (local2\Field2 = $00) Then
                text((graphicwidth Sar $01), (Int (((Float (local2\Field1 * $18)) * menuscale) + local1)), right(local2\Field0, (len(local2\Field0) - $01)), $01, $00)
            EndIf
        ElseIf (left(local2\Field0, $01) = "/") Then
            local5 = (Before local2)
        Else
            setfont(local0\Field2[$00])
            If (local2\Field2 = $00) Then
                text((graphicwidth Sar $01), (Int (((Float (local2\Field1 * $18)) * menuscale) + local1)), local2\Field0, $01, $00)
            EndIf
        EndIf
        If (local5 <> Null) Then
            If (local2\Field1 > local5\Field1) Then
                local2\Field2 = $01
            EndIf
        EndIf
        If (local2\Field2 <> 0) Then
            local4 = (local4 + $01)
        EndIf
        local3 = (local3 + $01)
    Next
    If ((Float (- stringheight(local5\Field0))) > (((Float (local5\Field1 * $18)) * menuscale) + local1)) Then
        creditstimer = ((local6\Field3[$01] * 0.5) + creditstimer)
        If (((0.0 <= creditstimer) And (255.0 > creditstimer)) <> 0) Then
            color((Int max(min(creditstimer, 255.0), 0.0)), (Int max(min(creditstimer, 255.0), 0.0)), (Int max(min(creditstimer, 255.0), 0.0)))
        ElseIf (255.0 <= creditstimer) Then
            color($FF, $FF, $FF)
            If (500.0 < creditstimer) Then
                creditstimer = -255.0
            EndIf
        Else
            color((Int max(min((- creditstimer), 255.0), 0.0)), (Int max(min((- creditstimer), 255.0), 0.0)), (Int max(min((- creditstimer), 255.0), 0.0)))
            If (-1.0 <= creditstimer) Then
                creditstimer = -1.0
            EndIf
        EndIf
    EndIf
    If (0.0 <> creditstimer) Then
        For local2 = Each creditsline
            If (local2\Field2 <> 0) Then
                setfont(local0\Field2[$00])
                If (left(local2\Field0, $01) = "/") Then
                    text((graphicwidth Sar $01), (Int ((Float ((graphicheight Sar $01) + (local4 Sar $01))) + ((Float (local2\Field1 * $18)) * menuscale))), right(local2\Field0, (len(local2\Field0) - $01)), $01, $00)
                Else
                    text((graphicwidth Sar $01), (Int ((((Float ((local2\Field1 - local5\Field1) * $18)) * menuscale) + (Float (graphicheight Sar $01))) - ((Float ((local4 Sar $01) * $18)) * menuscale))), local2\Field0, $01, $00)
                EndIf
            EndIf
        Next
    EndIf
    If (getkey() <> 0) Then
        creditstimer = -1.0
    EndIf
    If (-1.0 = creditstimer) Then
        freefont(local0\Field2[$00])
        freefont(local0\Field2[$01])
        freeimage(creditsscreen)
        creditsscreen = $00
        freeimage(i_end\Field1)
        i_end\Field1 = $00
        Delete Each creditsline
        nullgame($00)
        stopstream_strict(musicchn)
        shouldplay = $15
        ms\Field1 = $00
        ms\Field0 = $01
        ms\Field3 = $00
        currsave = ""
        flushkeys()
    EndIf
    Return $00
End Function
