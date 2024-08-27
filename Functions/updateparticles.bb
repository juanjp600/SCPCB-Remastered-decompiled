Function updateparticles%()
    Local local0.particles
    Local local1.fps_settings
    local1 = (First fps_settings)
    For local0 = Each particles
        moveentity(local0\Field1, 0.0, 0.0, (local0\Field8 * local1\Field3[$00]))
        If (0.0 <> local0\Field10) Then
            local0\Field9 = (local0\Field9 - (local0\Field10 * local1\Field3[$00]))
        EndIf
        translateentity(local0\Field1, 0.0, (local0\Field9 * local1\Field3[$00]), 0.0, $01)
        positionentity(local0\Field0, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $01)
        If (0.0 <> local0\Field14) Then
            local0\Field6 = min(max(((local0\Field14 * local1\Field3[$00]) + local0\Field6), 0.0), 1.0)
            entityalpha(local0\Field0, local0\Field6)
        EndIf
        If (0.0 <> local0\Field15) Then
            local0\Field7 = ((local0\Field15 * local1\Field3[$00]) + local0\Field7)
            scalesprite(local0\Field0, local0\Field7, local0\Field7)
        EndIf
        local0\Field16 = (local0\Field16 - local1\Field3[$00])
        If ((((0.0 >= local0\Field16) Or (0.00001 > local0\Field7)) Or (0.0 >= local0\Field6)) <> 0) Then
            removeparticle(local0)
        EndIf
    Next
    Return $00
End Function
