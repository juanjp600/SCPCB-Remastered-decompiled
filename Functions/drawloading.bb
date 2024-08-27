Function drawloading%(arg0%, arg1%)
    Local local0.fonts
    Local local1%
    Local local2%
    Local local3%
    Local local4.loadingscreens
    Local local5%
    Local local6%
    Local local7%
    Local local8$
    Local local9%
    Local local12%
    local0 = (First fonts)
    If (arg0 = $00) Then
        loadingscreentext = $00
        local3 = rand($01, loadingscreenamount)
        For local4 = Each loadingscreens
            If (local4\Field2 = local3) Then
                If (local4\Field1 = $00) Then
                    local4\Field1 = loadimage_strict(scpmodding_processfilepath(("LoadingScreens\" + local4\Field0)))
                EndIf
                local4\Field1 = resizeimage2(local4\Field1, (Int ((Float imagewidth(local4\Field1)) * menuscale)), (Int ((Float imageheight(local4\Field1)) * menuscale)))
                selectedloadingscreen = local4
                Exit
            EndIf
        Next
    EndIf
    local5 = $01
    Repeat
        clscolor($00, $00, $00)
        cls()
        If (arg0 > $14) Then
            updatemusic()
        EndIf
        If (arg1 = $00) Then
            If ((Float arg0) > ((100.0 / (Float selectedloadingscreen\Field8)) * (Float (loadingscreentext + $01)))) Then
                loadingscreentext = (loadingscreentext + $01)
            EndIf
        EndIf
        If (selectedloadingscreen\Field6 = $00) Then
            drawimage(loadingback, ((graphicwidth Sar $01) - (imagewidth(loadingback) Sar $01)), ((graphicheight Sar $01) - (imageheight(loadingback) Sar $01)), $00)
        EndIf
        If (selectedloadingscreen\Field4 = $00) Then
            local1 = ((graphicwidth Sar $01) - (imagewidth(selectedloadingscreen\Field1) Sar $01))
        ElseIf (selectedloadingscreen\Field4 = $01) Then
            local1 = (graphicwidth - imagewidth(selectedloadingscreen\Field1))
        Else
            local1 = $00
        EndIf
        If (selectedloadingscreen\Field5 = $00) Then
            local2 = ((graphicheight Sar $01) - (imageheight(selectedloadingscreen\Field1) Sar $01))
        ElseIf (selectedloadingscreen\Field5 = $01) Then
            local2 = (graphicheight - imageheight(selectedloadingscreen\Field1))
        Else
            local2 = $00
        EndIf
        drawimage(selectedloadingscreen\Field1, local1, local2, $00)
        local6 = $12C
        local7 = $14
        local1 = ((graphicwidth Sar $01) - (local6 Sar $01))
        local2 = (((graphicheight Sar $01) + $1E) - $64)
        rect(local1, local2, (Int ((4.0 * menuscale) + (Float local6))), local7, $00)
        color($AB, $18, $0E)
        rect((local1 + $01), (local2 + $01), (Int ((((4.0 * menuscale) + (Float local6)) - 2.0) * ((Float arg0) / 100.0))), (local7 - $02), $01)
        If (selectedloadingscreen\Field3 = "CWM") Then
            If (arg1 = $00) Then
                If (local5 <> 0) Then
                    If (arg0 = $00) Then
                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\990\cwm1.cwm")))
                    ElseIf (arg0 = $64) Then
                        playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\990\cwm2.cwm")))
                    EndIf
                EndIf
            EndIf
            aasetfont(local0\Field0[$01])
            local8 = ""
            local3 = rand($02, $09)
            For local9 = $00 To local3 Step $01
                local8 = (local8 + chr(rand($30, $7A)))
            Next
            aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), scplang_getphrase(local8), $01, $01, 1.0)
            If (arg0 = $00) Then
                If (rand($05, $01) = $01) Then
                    Select rand($02, $01)
                        Case $01
                            selectedloadingscreen\Field7[$00] = (((scplang_getphrase("dynamicloadingscreens.happenon") + " ") + currentdate()) + ".")
                        Case $02
                            selectedloadingscreen\Field7[$00] = currenttime()
                    End Select
                Else
                    Select rand($0D, $01)
                        Case $01
                            selectedloadingscreen\Field7[$00] = scplang_getphrase("dynamicloadingscreens.fineradio")
                        Case $02
                            selectedloadingscreen\Field7[$00] = scplang_getphrase("dynamicloadingscreens.burn")
                        Case $03
                            selectedloadingscreen\Field7[$00] = scplang_getphrase("dynamicloadingscreens.cannotcontrol")
                        Case $04
                            selectedloadingscreen\Field7[$00] = "sebotan is a monkey"
                        Case $05
                            selectedloadingscreen\Field7[$00] = scplang_getphrase("dynamicloadingscreens.trust")
                        Case $06
                            selectedloadingscreen\Field7[$00] = scplang_getphrase("dynamicloadingscreens.gentleman")
                        Case $07
                            selectedloadingscreen\Field7[$00] = "???____??_???__????n?"
                        Case $08,$09
                            selectedloadingscreen\Field7[$00] = scplang_getphrase("dynamicloadingscreens.jorge")
                        Case $0A
                            selectedloadingscreen\Field7[$00] = "???????????"
                        Case $0B
                            selectedloadingscreen\Field7[$00] = scplang_getphrase("dynamicloadingscreens.midnight")
                        Case $0C
                            selectedloadingscreen\Field7[$00] = "eddie is a jew"
                        Case $0D
                            selectedloadingscreen\Field7[$00] = scplang_getphrase("dynamicloadingscreens.alloylife")
                    End Select
                EndIf
            EndIf
            local8 = scplang_getphrase(selectedloadingscreen\Field7[$00])
            local3 = (len(selectedloadingscreen\Field7[$00]) - rand($05, $01))
            For local9 = $00 To rand($0A, $0F) Step $01
                local8 = replace(selectedloadingscreen\Field7[$00], mid(selectedloadingscreen\Field7[$00], rand($01, (len(local8) - $01)), $01), chr(rand($82, $FA)))
            Next
            aasetfont(local0\Field0[$00])
            rowtext(scplang_getphrase(local8), ((graphicwidth Sar $01) - $C8), ((graphicheight Sar $01) + $78), $190, $12C, $01, 1.0)
        ElseIf (selectedloadingscreen\Field3 = "SCP-789-J") Then
            color($00, $00, $00)
            aasetfont(local0\Field0[$01])
            aatext(((graphicwidth Sar $01) + $01), (((graphicheight Sar $01) + $50) + $01), selectedloadingscreen\Field3, $01, $01, 1.0)
            aasetfont(local0\Field0[$00])
            rowtext(scplang_getphrase(selectedloadingscreen\Field7[loadingscreentext]), (((graphicwidth Sar $01) - $C8) + $01), (((graphicheight Sar $01) + $78) + $01), $190, $12C, $01, 1.0)
            color($FF, $FF, $FF)
            aasetfont(local0\Field0[$01])
            aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), selectedloadingscreen\Field3, $01, $01, 1.0)
            aasetfont(local0\Field0[$00])
            rowtext(scplang_getphrase(selectedloadingscreen\Field7[loadingscreentext]), ((graphicwidth Sar $01) - $C8), ((graphicheight Sar $01) + $78), $190, $12C, $01, 1.0)
        ElseIf (selectedloadingscreen\Field3 = "Walter White") Then
            color($00, $00, $00)
            aasetfont(local0\Field0[$01])
            aatext(((graphicwidth Sar $01) + $01), (((graphicheight Sar $01) + $50) + $01), selectedloadingscreen\Field3, $01, $01, 1.0)
            aasetfont(local0\Field0[$00])
            rowtext(scplang_getphrase(selectedloadingscreen\Field7[loadingscreentext]), (((graphicwidth Sar $01) - $C8) + $01), (((graphicheight Sar $01) + $78) + $01), $190, $12C, $01, 1.0)
            color($FF, $FF, $FF)
            aasetfont(local0\Field0[$01])
            aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), selectedloadingscreen\Field3, $01, $01, 1.0)
            aasetfont(local0\Field0[$00])
            rowtext(scplang_getphrase(selectedloadingscreen\Field7[loadingscreentext]), ((graphicwidth Sar $01) - $C8), ((graphicheight Sar $01) + $78), $190, $12C, $01, 1.0)
        Else
            color($00, $00, $00)
            aasetfont(local0\Field0[$01])
            aatext(((graphicwidth Sar $01) + $01), (((graphicheight Sar $01) + $50) + $01), selectedloadingscreen\Field3, $01, $01, 1.0)
            aasetfont(local0\Field0[$00])
            rowtext(scplang_getphrase(selectedloadingscreen\Field7[loadingscreentext]), (((graphicwidth Sar $01) - $C8) + $01), (((graphicheight Sar $01) + $78) + $01), $190, $12C, $01, 1.0)
            color($FF, $FF, $FF)
            aasetfont(local0\Field0[$01])
            aatext((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), selectedloadingscreen\Field3, $01, $01, 1.0)
            aasetfont(local0\Field0[$00])
            rowtext(scplang_getphrase(selectedloadingscreen\Field7[loadingscreentext]), ((graphicwidth Sar $01) - $C8), ((graphicheight Sar $01) + $78), $190, $12C, $01, 1.0)
        EndIf
        color($00, $00, $00)
        aatext(((graphicwidth Sar $01) + $01), (((graphicheight Sar $01) - $64) + $01), (((scplang_getphrase("loadingscreens.loading") + " - ") + (Str arg0)) + " %"), $01, $01, 1.0)
        color($FF, $FF, $FF)
        aatext((graphicwidth Sar $01), ((graphicheight Sar $01) - $64), (((scplang_getphrase("loadingscreens.loading") + " - ") + (Str arg0)) + " %"), $01, $01, 1.0)
        If (arg0 = $64) Then
            If ((local5 And (selectedloadingscreen\Field3 = "SCP-789-J")) <> 0) Then
                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\789\butt.ogg")))
            EndIf
            If ((local5 And (selectedloadingscreen\Field3 = "Walter White")) <> 0) Then
                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\WW\walter.ogg")))
            EndIf
            aatext((graphicwidth Sar $01), (graphicheight - $32), scplang_getphrase("loadingscreens.anykey"), $01, $01, 1.0)
        Else
            flushkeys()
            flushmouse()
        EndIf
        If (borderlesswindowed <> 0) Then
            If (((realgraphicwidth <> graphicwidth) Or (realgraphicheight <> graphicheight)) <> 0) Then
                setbuffer(texturebuffer(fresize_texture, $00))
                clscolor($00, $00, $00)
                cls()
                copyrect($00, $00, graphicwidth, graphicheight, ($400 - (graphicwidth Sar $01)), ($400 - (graphicheight Sar $01)), backbuffer(), texturebuffer(fresize_texture, $00))
                setbuffer(backbuffer())
                clscolor($00, $00, $00)
                cls()
                scalerender(0.0, 0.0, ((2050.0 / (Float graphicwidth)) * aspectratioratio), ((2050.0 / (Float graphicwidth)) * aspectratioratio))
            EndIf
        EndIf
        If (1.0 < screengamma) Then
            copyrect($00, $00, realgraphicwidth, realgraphicheight, ($400 - (realgraphicwidth Sar $01)), ($400 - (realgraphicheight Sar $01)), backbuffer(), texturebuffer(fresize_texture, $00))
            entityblend(fresize_image, $01)
            clscolor($00, $00, $00)
            cls()
            scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)))
            entityfx(fresize_image, $21)
            entityblend(fresize_image, $03)
            entityalpha(fresize_image, (screengamma - 1.0))
            scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)))
        ElseIf (1.0 > screengamma) Then
            copyrect($00, $00, realgraphicwidth, realgraphicheight, ($400 - (realgraphicwidth Sar $01)), ($400 - (realgraphicheight Sar $01)), backbuffer(), texturebuffer(fresize_texture, $00))
            entityblend(fresize_image, $01)
            clscolor($00, $00, $00)
            cls()
            scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)))
            entityfx(fresize_image, $21)
            entityblend(fresize_image, $02)
            entityalpha(fresize_image, 1.0)
            setbuffer(texturebuffer(fresize_texture2, $00))
            clscolor((Int (255.0 * screengamma)), (Int (255.0 * screengamma)), (Int (255.0 * screengamma)))
            cls()
            setbuffer(backbuffer())
            scalerender((-1.0 / (Float realgraphicwidth)), (1.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)), (2048.0 / (Float realgraphicwidth)))
            setbuffer(texturebuffer(fresize_texture2, $00))
            clscolor($00, $00, $00)
            cls()
            setbuffer(backbuffer())
        EndIf
        entityfx(fresize_image, $01)
        entityblend(fresize_image, $01)
        entityalpha(fresize_image, 1.0)
        flip($00)
        local5 = $00
        If (arg0 <> $64) Then
            Exit
        EndIf
        local12 = $00
        If (((getkey() <> $00) Or mousehit($01)) <> 0) Then
            local12 = $01
            flushkeys()
            flushmouse()
            aasetfont(local0\Field0[$00])
        EndIf
    Until (local12 <> 0)
    Return $00
End Function
