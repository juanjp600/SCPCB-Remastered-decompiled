Function drawquickloading%()
    Local local0.fonts
    Local local1.fps_settings
    local0 = (First fonts)
    local1 = (First fps_settings)
    If (quickloadpercent > $FFFFFFFF) Then
        midhandle(quickloadicon)
        drawimage(quickloadicon, (graphicwidth - $5A), (graphicheight - $96), $00)
        color($FF, $FF, $FF)
        aasetfont(local0\Field0[$00])
        aatext((graphicwidth - $64), (graphicheight - $5A), (((scplang_getphrase("loadingscreens.loading") + ": ") + (Str quickloadpercent)) + "%"), $01, $00, 1.0)
        If (quickloadpercent > $63) Then
            If (70.0 > quickloadpercent_displaytimer) Then
                quickloadpercent_displaytimer = min((local1\Field3[$00] + quickloadpercent_displaytimer), 70.0)
            Else
                quickloadpercent = $FFFFFFFF
            EndIf
        EndIf
        quickloadevents()
    Else
        quickloadpercent = $FFFFFFFF
        quickloadpercent_displaytimer = 0.0
        quickload_currevent = Null
    EndIf
    Return $00
End Function
