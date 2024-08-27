Function updatedevilemitters%()
    Local local0.devilemitters
    Local local1%
    Local local2.fps_settings
    Local local3#
    local1 = $00
    local2 = (First fps_settings)
    For local0 = Each devilemitters
        If (((0.0 < local2\Field3[$00]) And ((playerroom = local0\Field5) Or (8.0 > local0\Field5\Field8))) <> 0) Then
            If (0.0 = local0\Field6) Then
                setemitter(local0\Field0, particleeffect[local0\Field4], $00)
                local0\Field6 = local2\Field3[$00]
            ElseIf (local0\Field7 > local0\Field6) Then
                local0\Field6 = min((local0\Field6 + local2\Field3[$00]), local0\Field7)
            Else
                local0\Field6 = 0.0
            EndIf
            If (local0\Field9 <> 0) Then
                local0\Field8 = loopsound2(hisssfx, local0\Field8, camera, local0\Field0, 10.0, 1.0)
                If (local1 = $00) Then
                    If ((((wearinggasmask = $00) And (wearinghazmat = $00)) And (wearingnightvision = $00)) <> 0) Then
                        local3 = distance(entityx(camera, $01), entityz(camera, $01), entityx(local0\Field0, $01), entityz(local0\Field0, $01))
                        If (0.8 > local3) Then
                            If (5.0 > (Abs (entityy(camera, $01) - entityy(local0\Field0, $01)))) Then
                                local1 = $01
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    If (local1 <> 0) Then
        If (420.0 < eyeirritation) Then
            blurvolume = max(blurvolume, ((eyeirritation - 420.0) / 1680.0))
        EndIf
        If (1680.0 < eyeirritation) Then
            deathmsg = scplang_getphrase("events.smokedeath")
            kill($00, $00)
        EndIf
        If (0.0 <= killtimer) Then
            If (rand($96, $01) = $01) Then
                If (coughchn = $00) Then
                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                ElseIf (channelplaying(coughchn) = $00) Then
                    coughchn = playsound_strict(coughsfx(rand($00, $02)))
                EndIf
            EndIf
        EndIf
        eyeirritation = ((local2\Field3[$00] * 4.0) + eyeirritation)
    EndIf
    Return $00
End Function
