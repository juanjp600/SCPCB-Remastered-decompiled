Function updateemitters%()
    Local local0.fps_settings
    Local local1.emitters
    Local local2.particles
    Local local3#
    local0 = (First fps_settings)
    insmoke = $00
    For local1 = Each emitters
        If (((0.0 < local0\Field3[$00]) And ((playerroom = local1\Field7) Or (8.0 > local1\Field7\Field8))) <> 0) Then
            local2 = createparticle(entityx(local1\Field0, $01), entityy(local1\Field0, $01), entityz(local1\Field0, $01), rand(local1\Field2, local1\Field3), local1\Field1, local1\Field4, local1\Field5)
            local2\Field8 = local1\Field9
            rotateentity(local2\Field1, entitypitch(local1\Field0, $01), entityyaw(local1\Field0, $01), entityroll(local1\Field0, $01), $01)
            turnentity(local2\Field1, rnd((- local1\Field10), local1\Field10), rnd((- local1\Field10), local1\Field10), 0.0, $00)
            turnentity(local2\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
            local2\Field15 = local1\Field11
            local2\Field14 = local1\Field12
            local1\Field8 = loopsound2(hisssfx, local1\Field8, camera, local1\Field0, 10.0, 1.0)
            If (insmoke = $00) Then
                If (((wearinggasmask = $00) And (wearinghazmat = $00)) <> 0) Then
                    local3 = distance(entityx(camera, $01), entityz(camera, $01), entityx(local1\Field0, $01), entityz(local1\Field0, $01))
                    If (0.8 > local3) Then
                        If (5.0 > (Abs (entityy(camera, $01) - entityy(local1\Field0, $01)))) Then
                            insmoke = $01
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    If (insmoke <> 0) Then
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
        eyeirritation = ((local0\Field3[$00] * 4.0) + eyeirritation)
    EndIf
    Return $00
End Function
