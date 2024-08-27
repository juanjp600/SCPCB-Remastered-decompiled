Function manipulatenpcbones%()
    Local local0.npcs
    Local local1%
    Local local2%
    Local local3$
    Local local4#
    Local local5#
    Local local6#
    Local local7#
    Local local8%
    Local local9#
    Local local10%
    For local0 = Each npcs
        If (local0\Field51 <> 0) Then
            local3 = getnpcmanipulationvalue(local0\Field57, local0\Field53, "bonename", $00)
            If (local3 <> "") Then
                local2 = createpivot($00)
                local1 = findchild(local0\Field0, local3)
                If (local1 = $00) Then
                    runtimeerror((((("ERROR: NPC bone " + chr($22)) + local3) + chr($22)) + " does not exist."))
                EndIf
                positionentity(local2, entityx(local1, $01), entityy(local1, $01), entityz(local1, $01), $00)
                local10 = local0\Field52
                If (local10 = $00) Then
                    For local8 = $01 To (Int getnpcmanipulationvalue(local0\Field57, local0\Field53, "controller_max", $01)) Step $01
                        If (getnpcmanipulationvalue(local0\Field57, local0\Field53, ("controlleraxis" + (Str local8)), $00) = "pitch") Then
                            local4 = (Float getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_max"), $02))
                            local5 = (Float getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_min"), $02))
                            local6 = (Float getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_offset"), $02))
                            If ((Int getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_inverse"), $03)) <> 0) Then
                                local9 = ((- deltapitch(local1, camera)) + local6)
                            Else
                                local9 = (deltapitch(local1, camera) + local6)
                            EndIf
                            local7 = (Float getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_smoothing"), $02))
                            If (0.0 < local7) Then
                                local0\Field54 = curveangle(local9, local0\Field54, local7)
                            Else
                                local0\Field54 = local9
                            EndIf
                            local0\Field54 = (Float changeanglevalueforcorrectboneassigning(local0\Field54))
                            local0\Field54 = max(min(local0\Field54, local4), local5)
                        ElseIf (getnpcmanipulationvalue(local0\Field57, local0\Field53, "controlleraxis1", $00) = "yaw") Then
                            local4 = (Float getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_max"), $02))
                            local5 = (Float getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_min"), $02))
                            local6 = (Float getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_offset"), $02))
                            If ((Int getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_inverse"), $03)) <> 0) Then
                                local9 = ((- deltayaw(local1, camera)) + local6)
                            Else
                                local9 = (deltayaw(local1, camera) + local6)
                            EndIf
                            local7 = (Float getnpcmanipulationvalue(local0\Field57, local0\Field53, (("controlleraxis" + (Str local8)) + "_smoothing"), $02))
                            If (0.0 < local7) Then
                                local0\Field55 = curveangle(local9, local0\Field55, local7)
                            Else
                                local0\Field55 = local9
                            EndIf
                            local0\Field55 = (Float changeanglevalueforcorrectboneassigning(local0\Field55))
                            local0\Field55 = max(min(local0\Field55, local4), local5)
                        EndIf
                    Next
                    rotateentity(local1, (entitypitch(local1, $00) + local0\Field54), (entityyaw(local1, $00) + local0\Field55), (entityroll(local1, $00) + local0\Field56), $00)
                EndIf
                freeentity(local2)
            EndIf
        EndIf
    Next
    Return $00
End Function
