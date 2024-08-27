Function use427%()
    Local local0%
    Local local1%
    Local local2.decals
    Local local3%
    Local local4#
    Local local5.fps_settings
    local4 = i_427\Field1
    local5 = (First fps_settings)
    If (25200.0 > i_427\Field1) Then
        If (i_427\Field0 = $01) Then
            i_427\Field1 = (i_427\Field1 + local5\Field3[$00])
            If (0.0 < injuries) Then
                injuries = max((injuries - (local5\Field3[$00] * 0.0005)), 0.0)
            EndIf
            If (((0.0 < bloodloss) And (1.0 >= injuries)) <> 0) Then
                bloodloss = max((bloodloss - (local5\Field3[$00] * 0.001)), 0.0)
            EndIf
            If (((0.0 < i_1079\Field0) And (1.0 >= injuries)) <> 0) Then
                i_1079\Field0 = max((i_1079\Field0 - (local5\Field3[$00] * 0.001)), 0.0)
            EndIf
            If (0.0 < i_008\Field0) Then
                i_008\Field0 = max((i_008\Field0 - (local5\Field3[$00] * 0.001)), 0.0)
            EndIf
            If (0.0 < i_409\Field0) Then
                i_409\Field0 = max((i_409\Field0 - (local5\Field3[$00] * 0.002)), 0.0)
            EndIf
            If (0.0 < i_357\Field0) Then
                i_357\Field0 = max((i_357\Field0 - (local5\Field3[$00] * 0.002)), 0.0)
            EndIf
            If (0.0 < i_207\Field0) Then
                i_207\Field0 = max((i_207\Field0 - (local5\Field3[$00] * 0.002)), 0.0)
            EndIf
            For local0 = $00 To $05 Step $01
                If (0.0 < scp1025state[local0]) Then
                    scp1025state[local0] = max((scp1025state[local0] - (local5\Field3[$00] * 0.001)), 0.0)
                EndIf
            Next
            If (i_427\Field2[$00] = $00) Then
                i_427\Field2[$00] = loadsound_strict(scpmodding_processfilepath("SFX\SCP\427\Effect.ogg"))
            EndIf
            If (channelplaying(i_427\Field3[$00]) = $00) Then
                i_427\Field3[$00] = playsound_strict(i_427\Field2[$00])
            EndIf
            If (12600.0 <= i_427\Field1) Then
                If (i_427\Field2[$01] = $00) Then
                    i_427\Field2[$01] = loadsound_strict(scpmodding_processfilepath("SFX\SCP\427\Transform.ogg"))
                EndIf
                If (channelplaying(i_427\Field3[$01]) = $00) Then
                    i_427\Field3[$01] = playsound_strict(i_427\Field2[$01])
                EndIf
            EndIf
            If (((4200.0 > local4) And (4200.0 <= i_427\Field1)) <> 0) Then
                msg = scplang_getphrase("ingame.scp2941")
                msgtimer = 350.0
            ElseIf (((12600.0 > local4) And (12600.0 <= i_427\Field1)) <> 0) Then
                msg = scplang_getphrase("ingame.scp2942")
                msgtimer = 350.0
            EndIf
        Else
            For local0 = $00 To $01 Step $01
                If (i_427\Field3[local0] <> $00) Then
                    If (channelplaying(i_427\Field3[local0]) <> 0) Then
                        stopchannel(i_427\Field3[local0])
                    EndIf
                EndIf
            Next
        EndIf
    Else
        If (((25200.0 > (local4 - local5\Field3[$00])) And (25200.0 <= i_427\Field1)) <> 0) Then
            msg = scplang_getphrase("ingame.scp2943")
            msgtimer = 350.0
        ElseIf (((27300.0 > (local4 - local5\Field3[$00])) And (27300.0 <= i_427\Field1)) <> 0) Then
            msg = scplang_getphrase("ingame.scp2944")
            msgtimer = 350.0
        EndIf
        i_427\Field1 = (i_427\Field1 + local5\Field3[$00])
        If (i_427\Field2[$00] = $00) Then
            i_427\Field2[$00] = loadsound_strict(scpmodding_processfilepath("SFX\SCP\427\Effect.ogg"))
        EndIf
        If (i_427\Field2[$01] = $00) Then
            i_427\Field2[$01] = loadsound_strict(scpmodding_processfilepath("SFX\SCP\427\Transform.ogg"))
        EndIf
        For local0 = $00 To $01 Step $01
            If (channelplaying(i_427\Field3[local0]) = $00) Then
                i_427\Field3[local0] = playsound_strict(i_427\Field2[local0])
            EndIf
        Next
        If (2.0 > rnd(200.0, 0.0)) Then
            local1 = createpivot($00)
            positionentity(local1, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
            turnentity(local1, 90.0, 0.0, 0.0, $00)
            entitypick(local1, 0.3)
            local2 = createdecal($14, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
            local2\Field2 = (rnd(0.03, 0.08) * 2.0)
            entityalpha(local2\Field0, 1.0)
            scalesprite(local2\Field0, local2\Field2, local2\Field2)
            local3 = playsound_strict(dripsfx(rand($00, $05)))
            channelvolume(local3, (rnd(0.0, 0.8) * sfxvolume))
            channelpitch(local3, rand($4E20, $7530))
            freeentity(local1)
            blurtimer = 800.0
        EndIf
        If (29400.0 <= i_427\Field1) Then
            kill($00, $00)
            deathmsg = ((chr($22) + scplang_getphrase("ingame.scp2945")) + chr($22))
        ElseIf (27300.0 <= i_427\Field1) Then
            If (crouch = $00) Then
                crouchchn = playsound_strict(crouchsfx)
            EndIf
            crouch = $01
        EndIf
    EndIf
    Return $00
End Function
