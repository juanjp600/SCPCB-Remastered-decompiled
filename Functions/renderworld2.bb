Function renderworld2%()
    Local local0.fonts
    Local local1.fps_settings
    Local local2%
    Local local3%
    Local local4%
    Local local5.npcs
    Local local6%
    Local local7%
    Local local8%
    Local local9#
    Local local10#
    Local local11#
    Local local12#
    Local local13#
    Local local14%
    Local local15%
    local0 = (First fonts)
    local1 = (First fps_settings)
    cameraprojmode(ark_blur_cam, $00)
    cameraprojmode(camera, $01)
    If (((wearingnightvision > $00) And (wearingnightvision < $03)) <> 0) Then
        ambientlight(min((Float (brightness Shl $01)), 255.0), min((Float (brightness Shl $01)), 255.0), min((Float (brightness Shl $01)), 255.0))
    ElseIf (wearingnightvision = $03) Then
        ambientlight(255.0, 255.0, 255.0)
    ElseIf (playerroom <> Null) Then
        If ((((playerroom\Field7\Field10 <> "room173intro") And (playerroom\Field7\Field10 <> "gateb")) And (playerroom\Field7\Field10 <> "gatea")) <> 0) Then
            ambientlight((Float brightness), (Float brightness), (Float brightness))
        EndIf
    EndIf
    isnvgblinking = $00
    hideentity(at\Field4[$04])
    cameraviewport(camera, $00, $00, graphicwidth, graphicheight)
    local2 = $02
    local3 = $00
    If (((wearingnightvision = $01) Or (wearingnightvision = $02)) <> 0) Then
        For local4 = $00 To (maxitemamount - $01) Step $01
            If (inventory(local4) <> Null) Then
                If ((((wearingnightvision = $01) And (inventory(local4)\Field3\Field1 = "nvgoggles")) Or ((wearingnightvision = $02) And (inventory(local4)\Field3\Field1 = "supernv"))) <> 0) Then
                    inventory(local4)\Field13 = (inventory(local4)\Field13 - (local1\Field3[$00] * (0.02 * (Float wearingnightvision))))
                    local3 = (Int inventory(local4)\Field13)
                    If (0.0 >= inventory(local4)\Field13) Then
                        local2 = $00
                        msg = scplang_getphrase("ingame.nvgdead")
                        blinktimer = -1.0
                        msgtimer = 350.0
                        Exit
                    ElseIf (100.0 >= inventory(local4)\Field13) Then
                        local2 = $01
                    EndIf
                EndIf
            EndIf
        Next
        If (local2 <> 0) Then
            renderworld(1.0)
        EndIf
    Else
        renderworld(1.0)
    EndIf
    currtrisamount = trisrendered()
    If (((local2 = $00) And (wearingnightvision <> $03)) <> 0) Then
        isnvgblinking = $01
        showentity(at\Field4[$04])
    EndIf
    If (((-16.0 > blinktimer) Or (-6.0 < blinktimer)) <> 0) Then
        If (((wearingnightvision = $02) And (local2 <> $00)) <> 0) Then
            nvtimer = (nvtimer - local1\Field3[$00])
            If (0.0 >= nvtimer) Then
                For local5 = Each npcs
                    local5\Field40 = entityx(local5\Field4, $01)
                    local5\Field41 = entityy(local5\Field4, $01)
                    local5\Field42 = entityz(local5\Field4, $01)
                Next
                isnvgblinking = $01
                showentity(at\Field4[$04])
                If (-10.0 >= nvtimer) Then
                    nvtimer = 600.0
                EndIf
            EndIf
            color($FF, $FF, $FF)
            aasetfont(local0\Field0[$02])
            local6 = $00
            If (local2 = $01) Then
                local6 = $28
            EndIf
            aatext((graphicwidth Sar $01), (Int ((Float ($14 + local6)) * menuscale)), scplang_getphrase("ingame.nvgr"), $01, $00, 1.0)
            aatext((graphicwidth Sar $01), (Int ((Float ($3C + local6)) * menuscale)), (Str max((Float f2s((nvtimer / 60.0), $01)), 0.0)), $01, $00, 1.0)
            aatext((graphicwidth Sar $01), (Int ((Float ($64 + local6)) * menuscale)), scplang_getphrase("ingame.nvgr2"), $01, $00, 1.0)
            local7 = createpivot($00)
            local8 = createpivot($00)
            positionentity(local7, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
            color($FF, $FF, $FF)
            For local5 = Each npcs
                If (((local5\Field43 <> "") And (local5\Field68 = $00)) <> 0) Then
                    positionentity(local8, local5\Field40, local5\Field41, local5\Field42, $00)
                    local9 = entitydistance(local8, collider)
                    If (23.5 > local9) Then
                        pointentity(local7, local8, 0.0)
                        local10 = wrapangle((entityyaw(camera, $00) - entityyaw(local7, $00)))
                        local11 = 0.0
                        If (((90.0 < local10) And (180.0 >= local10)) <> 0) Then
                            local11 = ((sin(90.0) / 90.0) * local10)
                        ElseIf (((180.0 < local10) And (270.0 > local10)) <> 0) Then
                            local11 = ((sin(270.0) / local10) * 270.0)
                        Else
                            local11 = sin(local10)
                        EndIf
                        local12 = wrapangle((entitypitch(camera, $00) - entitypitch(local7, $00)))
                        local13 = 0.0
                        If (((90.0 < local12) And (180.0 >= local12)) <> 0) Then
                            local13 = ((sin(90.0) / 90.0) * local12)
                        ElseIf (((180.0 < local12) And (270.0 > local12)) <> 0) Then
                            local13 = ((sin(270.0) / local12) * 270.0)
                        Else
                            local13 = sin(local12)
                        EndIf
                        If (isnvgblinking = $00) Then
                            aatext((Int ((local11 * (Float (graphicwidth Sar $01))) + (Float (graphicwidth Sar $01)))), (Int ((Float (graphicheight Sar $01)) - (local13 * (Float (graphicheight Sar $01))))), local5\Field43, $01, $01, 1.0)
                            aatext((Int ((local11 * (Float (graphicwidth Sar $01))) + (Float (graphicwidth Sar $01)))), (Int (((Float (graphicheight Sar $01)) - (local13 * (Float (graphicheight Sar $01)))) + (30.0 * menuscale))), (f2s(local9, $01) + " m"), $01, $01, 1.0)
                        EndIf
                    EndIf
                EndIf
            Next
            freeentity(local7)
            freeentity(local8)
            color($00, $00, $37)
            For local14 = $00 To $0A Step $01
                rect($2D, (Int (((Float graphicheight) * 0.5) - (Float (local14 * $14)))), $36, $0A, $01)
            Next
            color($00, $00, $FF)
            For local15 = $00 To (Int floor(((Float (local3 + $32)) * 0.01))) Step $01
                rect($2D, (Int (((Float graphicheight) * 0.5) - (Float (local15 * $14)))), $36, $0A, $01)
            Next
            drawimage(nvgimages, $28, (Int (((Float graphicheight) * 0.5) + 30.0)), $01)
            color($FF, $FF, $FF)
        ElseIf (((wearingnightvision = $01) And (local2 <> $00)) <> 0) Then
            color($00, $37, $00)
            For local14 = $00 To $0A Step $01
                rect($2D, (Int (((Float graphicheight) * 0.5) - (Float (local14 * $14)))), $36, $0A, $01)
            Next
            color($00, $FF, $00)
            For local15 = $00 To (Int floor(((Float (local3 + $32)) * 0.01))) Step $01
                rect($2D, (Int (((Float graphicheight) * 0.5) - (Float (local15 * $14)))), $36, $0A, $01)
            Next
            drawimage(nvgimages, $28, (Int (((Float graphicheight) * 0.5) + 30.0)), $00)
        EndIf
    EndIf
    cameraprojmode(ark_blur_cam, $02)
    cameraprojmode(camera, $00)
    renderworld(1.0)
    cameraprojmode(ark_blur_cam, $00)
    If (((-16.0 > blinktimer) Or (-6.0 < blinktimer)) <> 0) Then
        If (((((wearingnightvision = $01) Or (wearingnightvision = $02)) And (local2 = $01)) And ((millisecs2() Mod $320) < $190)) <> 0) Then
            color($FF, $00, $00)
            aasetfont(local0\Field0[$02])
            aatext((graphicwidth Sar $01), (Int (20.0 * menuscale)), scplang_getphrase("ingame.nvgr3"), $01, $00, 1.0)
            color($FF, $FF, $FF)
        EndIf
    EndIf
    Return $00
End Function
