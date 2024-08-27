Function updateroomlights%(arg0%)
    Local local0.rooms
    Local local1%
    Local local2#
    Local local3#
    Local local4#
    Local local5.fps_settings
    local5 = (First fps_settings)
    For local0 = Each rooms
        If ((((hidedistance * 0.7) > local0\Field8) Or (local0 = playerroom)) <> 0) Then
            For local1 = $00 To local0\Field28 Step $01
                If (local0\Field16[local1] <> $00) Then
                    If (((enableroomlights And (0.5 < secondarylighton)) And (arg0 = camera)) <> 0) Then
                        entityorder(local0\Field31[local1], $FFFFFFFF)
                        If (0.0 = updateroomlightstimer) Then
                            showentity(local0\Field18[local1])
                            If (8.5 > entitydistance(arg0, local0\Field16[local1])) Then
                                If (local0\Field32[local1] <> 0) Then
                                    showentity(local0\Field16[local1])
                                    local0\Field32[local1] = $00
                                EndIf
                            ElseIf (local0\Field32[local1] = $00) Then
                                hideentity(local0\Field16[local1])
                                local0\Field32[local1] = $01
                            EndIf
                            If (((8.5 > entitydistance(arg0, local0\Field31[local1])) Or local0\Field7\Field17) <> 0) Then
                                If ((entityvisible(arg0, local0\Field30[local1]) Or local0\Field7\Field17) <> 0) Then
                                    If (local0\Field29[local1] <> 0) Then
                                        showentity(local0\Field31[local1])
                                        local0\Field29[local1] = $00
                                    EndIf
                                    If (playerroom\Field7\Field10 = "room173intro") Then
                                        local2 = rnd(0.38, 0.42)
                                    ElseIf (local0\Field33[local1] < $05) Then
                                        local2 = rnd(0.38, 0.42)
                                    ElseIf (((local0\Field33[local1] > $04) And (local0\Field33[local1] < $0A)) <> 0) Then
                                        local2 = rnd(0.35, 0.45)
                                    Else
                                        local2 = rnd(0.3, 0.5)
                                    EndIf
                                    scalesprite(local0\Field31[local1], local2, local2)
                                    local4 = ((entitydistance(arg0, local0\Field30[local1]) + 0.5) / 7.5)
                                    local4 = max(min(local4, 1.0), 0.0)
                                    local3 = inverse(local4)
                                    If (0.0 < local3) Then
                                        entityalpha(local0\Field31[local1], (max(((Float ((brightness / $FF) * $03)) * (local0\Field17[local1] / 2.0)), 1.0) * local3))
                                    ElseIf (local0\Field29[local1] = $00) Then
                                        hideentity(local0\Field31[local1])
                                        local0\Field29[local1] = $01
                                    EndIf
                                    If (local0\Field7\Field17 <> 0) Then
                                        If (((8.5 <= entitydistance(arg0, local0\Field31[local1])) Or (entityvisible(arg0, local0\Field30[local1]) = $00)) <> 0) Then
                                            hideentity(local0\Field31[local1])
                                            local0\Field29[local1] = $01
                                        EndIf
                                    EndIf
                                ElseIf (local0\Field29[local1] = $00) Then
                                    hideentity(local0\Field31[local1])
                                    local0\Field29[local1] = $01
                                EndIf
                            ElseIf (local0\Field29[local1] = $00) Then
                                hideentity(local0\Field31[local1])
                                local0\Field29[local1] = $01
                                If (local0\Field43[local1] <> $00) Then
                                    hideentity(local0\Field43[local1])
                                EndIf
                                If (local0\Field44[local1] <> $00) Then
                                    hideentity(local0\Field44[local1])
                                EndIf
                            EndIf
                            If (local0\Field43[local1] <> $00) Then
                                showentity(local0\Field43[local1])
                            EndIf
                            If (local0\Field44[local1] <> $00) Then
                                If (((0.0 < local0\Field45[local1]) And (10.0 > local0\Field45[local1])) <> 0) Then
                                    showentity(local0\Field44[local1])
                                    local0\Field45[local1] = (local0\Field45[local1] + local5\Field3[$00])
                                Else
                                    hideentity(local0\Field44[local1])
                                    local0\Field45[local1] = 0.0
                                EndIf
                            EndIf
                            If (local0\Field43[local1] <> $00) Then
                                scaleentity(local0\Field43[local1], (max(((-0.4 + local2) * 0.025), 0.0) + 0.005), (max(((-0.4 + local2) * 0.025), 0.0) + 0.005), (max(((-0.4 + local2) * 0.025), 0.0) + 0.005), $00)
                                If (local0\Field33[local1] > $04) Then
                                    If (rand($190, $01) = $01) Then
                                        setemitter(local0\Field30[local1], particleeffect[$00], $00)
                                        playsound2(introsfx(rand($0A, $0C)), arg0, local0\Field30[local1], 10.0, 1.0)
                                        showentity(local0\Field44[local1])
                                        local0\Field45[local1] = local5\Field3[$00]
                                    EndIf
                                EndIf
                            EndIf
                        Else
                            If (((8.5 > entitydistance(arg0, local0\Field31[local1])) Or local0\Field7\Field17) <> 0) Then
                                If (playerroom\Field7\Field10 = "room173intro") Then
                                    local2 = rnd(0.38, 0.42)
                                ElseIf (local0\Field33[local1] < $05) Then
                                    local2 = rnd(0.38, 0.42)
                                ElseIf (((local0\Field33[local1] > $04) And (local0\Field33[local1] < $0A)) <> 0) Then
                                    local2 = rnd(0.35, 0.45)
                                Else
                                    local2 = rnd(0.3, 0.5)
                                EndIf
                                If (local0\Field29[local1] = $00) Then
                                    scalesprite(local0\Field31[local1], local2, local2)
                                EndIf
                            EndIf
                            If (local0\Field43[local1] <> $00) Then
                                scaleentity(local0\Field43[local1], (max(((-0.4 + local2) * 0.025), 0.0) + 0.005), (max(((-0.4 + local2) * 0.025), 0.0) + 0.005), (max(((-0.4 + local2) * 0.025), 0.0) + 0.005), $00)
                            EndIf
                            If (local0\Field44[local1] <> $00) Then
                                If (((0.0 < local0\Field45[local1]) And (10.0 > local0\Field45[local1])) <> 0) Then
                                    showentity(local0\Field44[local1])
                                    local0\Field45[local1] = (local0\Field45[local1] + local5\Field3[$00])
                                Else
                                    hideentity(local0\Field44[local1])
                                    local0\Field45[local1] = 0.0
                                EndIf
                            EndIf
                        EndIf
                        updateroomlightstimer = (local5\Field3[$00] + updateroomlightstimer)
                        If (8.0 <= updateroomlightstimer) Then
                            updateroomlightstimer = 0.0
                        EndIf
                    ElseIf (arg0 = camera) Then
                        If (0.5 >= secondarylighton) Then
                            hideentity(local0\Field18[local1])
                        Else
                            showentity(local0\Field18[local1])
                        EndIf
                        If (local0\Field32[local1] = $00) Then
                            hideentity(local0\Field16[local1])
                            local0\Field32[local1] = $01
                        EndIf
                        If (local0\Field29[local1] = $00) Then
                            hideentity(local0\Field31[local1])
                            local0\Field29[local1] = $01
                        EndIf
                        If (local0\Field43[local1] <> $00) Then
                            hideentity(local0\Field43[local1])
                        EndIf
                        If (local0\Field44[local1] <> $00) Then
                            hideentity(local0\Field44[local1])
                        EndIf
                    Else
                        entityorder(local0\Field31[local1], $00)
                    EndIf
                EndIf
            Next
        EndIf
    Next
    Return $00
End Function
